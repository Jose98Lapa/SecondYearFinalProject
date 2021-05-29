grammar gramatica_formulario;

/*
 *   Lexico
 */

gramatica: 'BEGIN' lista_linhas 'END';

lista_linhas: lista_linhas expressao
   | expressao
   ;

expressao: expressao_inicializacao
   | expr
   | estrutura_condicional
   | expressao_atribuicao
   ;

expressao_inicializacao: TIPODADOS ident
   | TIPODADOS ident OPERADORATRIBUICAO expr
   | TIPODADOS ident OPERADORATRIBUICAO tipo_dados
   ;

expressao_atribuicao: ident OPERADORATRIBUICAO tipo_dados
   ;

expr: expr op tipo_dados
   | ident OPERADORATRIBUICAO expr
   ;

tipo_dados: ident
   | integer
   | float
   ;

integer
   : '-'? NUMERO
   ;

float
   : '-'? REAL
   ;

ident: TEXTO
   ;

op
   : OPERADORLOGICO
   | OPERADORMATEMATICO
   ;


estrutura_condicional: ife
                       elsee?
                       END_STATEMENT
                       ;

ife               : SE ( VARIAVEL | VALOR ) OPERADORLOGICO ( VARIAVEL | VALOR ) ENTAO
                      expressao+
                      ;
elsee               : SENAO
                      expressao+
                      ;


/*
 *  Sintaxe
 */

fragment DIGITO     : [0-9];
fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];

VARIAVEL            : ('$' TEXTO) | ('$' ( TEXTO | NUMERO )+);
VALOR               : '$' DIGITO | '$' NUMERO;

ESPACO              : [ \t\r\n]+ -> skip ;
NOVALINHA           : ('\r'? '\n' | '\r')+;

// RESERVED KEYWORDS
SE                  : 'se';
ENTAO               : 'entao';
SENAO               : 'senao';
END_STATEMENT       : 'es';

NUMERO              : DIGITO+;
REAL                : DIGITO+ ( [.,] DIGITO+ )?;
TEXTO               : (( UPPERCASE )?( LOWERCASE ))+;
TIPODADOS           : 'NUMERO' | 'REAL' | 'TEXTO';

OPERADORLOGICO      : ( '<' | '>' | '=' | '!=' | '>=' | '<=' | 'ou' | 'e' );
OPERADORMATEMATICO  : ( '-' | '+' | '*' | '/' );
OPERADORATRIBUICAO  : '->';