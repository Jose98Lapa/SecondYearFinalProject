grammar gramatica_atividade_automatica;

/*
 *   Lexico
 */

gramatica: 'BEGIN' instrucao* 'END';

instrucao: expressao_inicializacao
   | expr
   | estrutura_condicional
   | expressao_atribuicao
   | estrutura_xml
   | enviar_email
   | update_informacao
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

expr: expr op ='+' expr
    | expr op ='-' expr
    | expr op ='/' expr
    | expr op ='*' expr
    | atom = tipo_dados;

tipo_dados: identidade
   | integer
   | floate
   ;

integer
   : '-'? NUMERO
   ;

floate
   : '-'? REAL
   ;

identidade: VARIAVEL
   ;

/*
xml_path: '['(TEXTO|NUMERO)+']'
   ;

op
   : OPERADORLOGICO
   | OPERADORMATEMATICO
   ;
*/

estrutura_xml: inicializacao_tipo_ficheiro
               inicializacao_elemento+
               END_FICHEIRO
               ;

enviar_email: SEND_EMAIL '(' identidade ',' identidade ',' identidade')'
              ;

update_informacao: UPDATE '(' (TEXTO|NUMERO)+  ','  (TEXTO|NUMERO)+ ',' (TEXTO|NUMERO)+ ')' '->' '(' (TEXTO|NUMERO)+ ',' identidade ')'
              ;

estrutura_condicional: ife
                       elsee?
                       END_SE
                       ;

ife               : SE ( identidade | integer ) OPERADORLOGICO ( identidade | integer ) (OPERADORLOGICO_EC ( identidade | integer ) OPERADORLOGICO ( identidade | integer ))*  OPERADORLOGICO? ENTAO
                      instrucao+
                      ;
elsee               : SENAO
                      instrucao+
                      ;


fragment DIGITO     : [0-9];
fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];

VARIAVEL            : '$' (TEXTO) [_]? (TEXTO | NUMERO )*;

OPERADORLOGICO      : ( '<' | '>' | '=' | '!=' | '>=' | '<=' );
OPERADORLOGICO_EC   : ('ou' | 'e');
OPERADORMATEMATICO  : ( '-' | '+' | '*' | '/' );
OPERADORATRIBUICAO  : '->';

//NOVALINHA           : ('\r'? '\n' | '\r')+;

// RESERVED KEYWORDS
SE                  : 'se';
ENTAO               : 'entao';
SENAO               : 'senao';
END_SE              : 'es';

TIPODADOS           : 'NUMERO' | 'REAL' | 'TEXTO';
ELEMENTO           : 'ELEMENTO';

TIPOFICHEIRO           : 'XML';
END_FICHEIRO           : 'LMX';
SEND_EMAIL             : 'ENVIAR_EMAIL';
UPDATE                 : 'ATUALIZAR';


NUMERO              : DIGITO+;
REAL                : DIGITO+ ( [.,] DIGITO+ )?;
TEXTO               : (( UPPERCASE )?( LOWERCASE ))+;
NOME_FICHEIRO       : (TEXTO|NUMERO)+  '.' TEXTO ;

COMMENT: '/*' .*? '*/' -> skip
;
COMMENTLINE: '//' ~[\r\n]* -> skip
;
ESPACO              : [ \t\r\n]+ -> skip ;
