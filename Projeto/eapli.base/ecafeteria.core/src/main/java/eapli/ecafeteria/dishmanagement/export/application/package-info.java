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
 * Export dishes.
 *
 * <p>
 * REQUIREMENTS
 * </p>
 * <ul>
 * <li>Export all the dishes in the system to a file
 * <li>Support different file formats, e.g., CSV, JSON, XML, and potentially multiple schemas</li>
 * </ul>
 * </p>
 *
 * <p>
 * ANALISYS
 * </p>
 * <p>
 * No changes are needed to the domain model. This is basically an "output" use case where the domain is read (in this
 * case the full list of dishes) and outputed in some specific representation to a file.
 * </p>
 *
 * <p>
 * DESIGN
 * </p>
 * <p>
 * Since we need to support multiple formats, a Strategy can define the common service and provide for an extension
 * point. A service object can act as a template/director with the stable part of the export algorithm. We basically
 * need to:
 * <ol>
 * <li>open/create the output file (and write any document/collection begin element)</li>
 * <li>iterate thru all dishes</li>
 * <li>for each dish, export it
 * <li>if there are more dishes to iterate, create a separator element (if applicable for the format)
 * <li>after iterating all the elements, close the output file (beforehand write any document/collection end element)
 * </ol>
 * </p>
 * <p>
 * <img src="export-seq.svg">
 * </p>
 * <p>
 * <img src="export-classes.svg">
 * </p>
 *
 * @author Paulo Gandra de Sousa 28/04/2020
 *
 *         <!--
 * @startuml export-seq.svg
 *
 *           DishExportController -> DishRepository:allDishes
 *           DishExportController <-- DishRepository: dishes
 *           DishExportController -> DishExporterFactory:build(fmt)
 *           participant DishExporter <<interface>>
 *           create DishExporter
 *           DishExporterFactory -> DishExporter: new
 *           DishExportController -> DishExportService : export(dishes, filename, fmt)
 *           activate DishExportService
 *           group loop [dishes]
 *           DishExportService -> DishExporter : begin(filename)
 *           DishExportService -> DishExporter : element(aDish)
 *           group alt [has next]
 *           DishExportService -> DishExporter : separator
 *           end group
 *           DishExportService -> DishExporter : end
 *           end group
 *           deactivate DishExportService
 *
 * @enduml
 *         -->
 *
 *         <!--
 * @startuml export-classes.svg
 *
 *           interface DishExporter{
 *           +begin()
 *           +element()
 *           +separator()
 *           +end()
 *           }
 *
 *           enum FileFormat
 *
 *           class DishExportService{
 *           +export()
 *           }
 *
 *           DishRepository ..> Dish
 *           DishExportController ..> DishRepository
 *           DishExportService ..> Dish
 *           DishExportController ..> FileFormat
 *           DishExporterFactory ..> FileFormat
 *           DishExportController ..> DishExportService
 *           DishExporterFactory <.down. DishExportController
 *           DishExporterFactory ..> DishExporter
 *           DishExportService ..> DishExporter
 *           DishExporter <|.. CsvDishExporter
 *           DishExporter <|.. XmlDishExporter
 *
 *
 * @enduml
 *         -->
 *
 */
package eapli.ecafeteria.dishmanagement.export.application;