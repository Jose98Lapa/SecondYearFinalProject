/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/**
 * <h1>As chef I want to import the dishes from files in different formats.</h1>
 *
 * <h2>REQUIREMENTS</h2>
 * </p>
 * <ul>
 * <li>Support different file formats, e.g., CSV, JSON, XML, and potentially multiple schemas</li>
 * <li>Provide an error log if some "entry" in the source file is invalid</li>
 * <ul>
 * <li>syntax (e.g., malformed XML element)</li>
 * <li>semantic (e.g., unknown dish type)</li>
 * </ul>
 * <li>do not change the source file</li>
 * <li>the entries in error should be "copied" to a file with the same format and schema as the source
 * <li>If a dish already exists it should be updated</li>
 * <li>In the end a summary should be shown to the user: how many dishes were imported, how many of those were new or
 * already existed, and how many errors</li>
 * </ul>
 * </p>
 * <p>
 * </p>
 *
 * <h2>ANALISYS</h2>
 * <p>
 * The domain model does not need to change. There are some mandatory attributes in the Dish that must be present in the
 * file otherwise it won't be possible to import the dish.
 * </p>
 * <p>
 * Potentially, the number of dishes to import might be quite large (in the order of hundreds)
 * </p>
 *
 * <h2>DESIGN</h2>
 * <p>
 * We need a variation point for the format of the input (e.g., XML, CSV, ...) so some kind of importing strategy will
 * be in place. Independently of the file format, the import algorithm is pretty much the same and as such should be
 * kept isolated from the file format specifics to improve reuse and avoid duplication (e.g., as a template method)
 * </p>
 * <p>
 * The general algorithm (in pseudocode) is as follows:
 *
 * <pre>
 * <code>
 * open file
 * repeat
 *     read element
 *     if element was read
 *         register or update dish
 *         increase count of new/updated dishes
 *     end if
 *     if error then
 *         log error
 *         copy element in error to error file
 *         increase count of errors
 *     end if
 * until there is no more content to process in the file
 * close file
 * </code>
 * </pre>
 * </p>
 * <p>
 * Since we need to read all the content of a file we can abstract that as an "iterator" that returns either a dish DTO
 * or an error content. DTO's can be passed to the controllers to update or register the dish, while the error can be
 * logged and passed back to the strategy to create the error file.
 *
 * <pre>
 * <code>
 * interface DishImporter {
 *    Iterator&lt;Either&lt;ContentInError, DishDTO&gt;&gt; iterator(sourceFilename)
 *    copyElementInError(errorFilename, errorElement)
 * }
 * </code>
 * </pre>
 *
 * We opt to have the interface to write the element in error to be flexible o that the calling code can present the
 * content in error to the user to try to correct immediately, otherwise we could simply assume the iterator would only
 * return valid content and would internally save the errors to the desired error file.
 * </p>
 * <p>
 * We are also using a functional monad for returning either the DTO or the Error instead of relying on exception to
 * control the execution flow, otherwise the interface would be:
 *
 * <pre>
* <code>
* interface DishImporter {
*    Iterator&lt;DishDTO&gt; iterator(sourceFilename)
*    copyElementInError(errorFilename, errorElement)
* }
* </code>
 * </pre>
 *
 * But, the {@code next()} method of the iterator should throw, e.g., {@code InvalidContentException} and we should
 * catch it to handle the file content in error. This is contrary to exception handling where exceptions should not be
 * used to control the execution flow. In this case, we expect to have invalid content as as such should properly code
 * the execution flow without the extra burden of catching exceptions.
 * </p>
 * <p>
 * One final method of the interface should be some cleanup entry point to allow the importer to cleanup even if there
 * are exceptions during the process.
 * </p>
 * <p>
 * <img src="sequence.svg">
 * </p>
 *
 *
 * @author Paulo Gandra de Sousa 05/05/2020
 *
 *         <!--
 * @startuml sequence.svg
 *
 *           DishImporterUI -> DishImporterController: import(format, sourceFilename, errorFilename)
 *           DishImporterController -> DishImporterFactory: build(format)
 *           create DishImportService
 *           create DishImporter
 *           DishImporterFactory -> DishImporter: new
 *           DishImporterController -> DishImportService : import(sourceFilename, errorFilename)
 *
 *           group try
 *           DishImportService -> DishImporter: iterator
 *
 *           group loop [hasNext]
 *           DishImportService -> DishImporter: next
 *           DishImportService -> DishRepository: containsOfIdentity
 *
 *           group alt dish does not exist
 *           create Dish
 *           DishImportService -> Dish: new
 *           DishImportService -> DishRepository: save
 *           DishImportService -> DishImportService: increaseNew
 *           end group
 *
 *           group alt dish already exists
 *           DishImportService -> DishRepository: ofIdentity
 *           create Dish
 *           DishRepository -> Dish: new
 *           DishImportService -> Dish: update
 *           DishImportService -> DishRepository: save
 *           DishImportService -> DishImportService: increaseUpdated
 *           end group
 *
 *           group alt content in error
 *           DishImportService -> DishImporter: copyElementInError
 *           DishImportService -> DishImportService: logError
 *           DishImportService -> DishImportService: increaseErrors
 *           end group
 *           end
 *
 *           group finally
 *           DishImportService -> DishImporter : cleanup
 *           end group
 *           end group
 * @enduml
 *         -->
 */
package eapli.ecafeteria.dishmanagement.import_.application;