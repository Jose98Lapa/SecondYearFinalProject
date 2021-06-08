grammar gramatica_formulario;

/*
 *   Lexico
 */

gramatica: 'BEGIN' instrucao* 'END';

instrucao: expressao_inicializacao
   | expr
   | estrutura_condicional
   | expressao_atribuicao
   | estrutura_xml
   ;


inicializacao_tipo_ficheiro: TIPOFICHEIRO identidade
   | TIPOFICHEIRO identidade OPERADORATRIBUICAO '"' NOME_FICHEIRO '"'
   ;

inicializacao_elemento: ELEMENTO identidade
   | ELEMENTO  atribuicao_elemento;

atribuicao_elemento: identidade OPERADORATRIBUICAO 'FIND' '[' (TEXTO|NUMERO)+ ']' 'where' '(' (TEXTO|NUMERO)+ ',' (TEXTO|NUMERO)+ ')'
   ;

expressao_inicializacao: TIPODADOS identidade
   | TIPODADOS expressao_atribuicao
   ;

expressao_atribuicao: identidade OPERADORATRIBUICAO expr
    | identidade OPERADORATRIBUICAO identidade'(' (TEXTO|NUMERO)+ ')'
   ;

/*expr: expr op tipo_dados
   | identidade OPERADORATRIBUICAO expr
   ;
*/

expr: expr '+' expr
    | expr '-' expr
    | expr '/' expr
    | expr '*' expr
    | tipo_dados;

tipo_dados: identidade
   | integer
   | float
   ;

integer
   : '-'? NUMERO
   ;

float
   : '-'? REAL
   ;

identidade: VARIAVEL
   ;

xml_path: '['(TEXTO|NUMERO)+']'
   ;

op
   : OPERADORLOGICO
   | OPERADORMATEMATICO
   ;

estrutura_xml: inicializacao_tipo_ficheiro
               inicializacao_elemento+
               END_FICHEIRO
               ;

estrutura_condicional: ife
                       elsee?
                       END_SE
                       ;

ife               : SE ( identidade | NUMERO ) OPERADORLOGICO ( identidade | NUMERO ) ENTAO
                      instrucao+
                      ;
elsee               : SENAO
                      instrucao+
                      ;


fragment DIGITO     : [0-9];
fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];

VARIAVEL            : '$' (TEXTO) [_]? (TEXTO | NUMERO )*;

COMMENT: '/*' .*? '*/' -> skip
;

COMMENTLINE: '//' ~[\r\n]* -> skip
;

ESPACO              : [ \t\r\n]+ -> skip ;

NOVALINHA           : ('\r'? '\n' | '\r')+;

// RESERVED KEYWORDS
SE                  : 'se';
ENTAO               : 'entao';
SENAO               : 'senao';
END_SE              : 'es';

NUMERO              : DIGITO+;
REAL                : DIGITO+ ( [.,] DIGITO+ )?;
TEXTO               : (( UPPERCASE )?( LOWERCASE ))+;
TIPODADOS           : 'NUMERO' | 'REAL' | 'TEXTO';

TIPOFICHEIRO           : 'XML';
END_FICHEIRO           : 'LMX';

ELEMENTO           : 'ELEMENTO';

NOME_FICHEIRO          : (TEXTO|NUMERO)+  '.' TEXTO ;

OPERADORLOGICO      : ( '<' | '>' | '=' | '!=' | '>=' | '<=' | 'ou' | 'e' );
OPERADORMATEMATICO  : ( '-' | '+' | '*' | '/' );
OPERADORATRIBUICAO  : '->';
