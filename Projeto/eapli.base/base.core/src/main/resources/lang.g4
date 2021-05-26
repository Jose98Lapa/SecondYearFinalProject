grammar lang;

/*
 *   Lexico
 */

gramm: expressao;


expressao:   estrutura_condicional
            |  atribuir_a_variavel
            | TIPODADOS
            | EOF;

estrutura_condicional: ife
                       elsee?
                       ;

ife               : SE ESPACO ( VARIAVEL | VALOR ) ESPACO OPERADORLOGICO ESPACO ( VARIAVEL | VALOR )
                      expressao+
                      END_STATEMENT
                      ;
elsee               : ENTAO
                      expressao+
                      END_STATEMENT
                      ;

atribuir_a_variavel : VARIAVEL OPERADORATRIBUICAO VALOR;

/*
 *  Sintaxe
 */

fragment DIGITO     : [0-9];
fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];


NUMERO              : DIGITO+;
REAL                : DIGITO+ ( [.,] DIGITO+ )?;
TEXTO               : (( UPPERCASE )?( LOWERCASE ))+;
TIPODADOS           : NUMERO | REAL | TEXTO;

OPERADORLOGICO      : ( '<' | '>' | '=' | '!=' | '>=' | '<=' | 'ou' | 'e' );
OPERADORMATEMATICO  : ( '-' | '+' | '*' | '/' );
OPERADORATRIBUICAO  : '->';

VARIAVEL            : '§' TEXTO | '§' ( TEXTO | NUMERO )+;
VALOR               : '§' DIGITO | '§' NUMERO;

ESPACO              : [ \t\r\n]+ -> skip ;
NOVALINHA           : ('\r'? '\n' | '\r')+;


// RESERVED KEYWORDS
SE                  : 'se';
ENTAO               : 'entao';
SENAO               : 'senao';
END_STATEMENT       : 'es';