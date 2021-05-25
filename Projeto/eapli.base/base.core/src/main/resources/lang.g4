grammar lang;

/*
 *   Lexico
 */

gramm: expressao+;


expressao:    TEXTO
            | estrutura_condicional
            | EOF;

estrutura_condicional: if
                       else?
                       ;

if                  : SE ( VARIAVEL | VALOR ) OPERADORCONDICIONAL ( VARIAVEL | VALOR )
                      expressao+
                      END_STATEMENT
                      ;
else                : ENTAO
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
TEXTO               : ( UPPERCASE )?( LOWERCASE )+;
TIPODADOS           : NUMERO | REAL | TEXTO;

OPERADORLOGICO      : ( '<' | '>' | '=' | '!=' | '>=' | '<=' | 'ou' | 'e' );
OPERADORMATEMATICO  : ( '-' | '+' | '*' | '/' );
OPERADORATRIBUICAO  : '->';

VARIAVEL            : '§' TEXTO | '§' ( TEXTO | NUMERO )+;
VALOR               : '§' DIGITO | '§' NUMERO;

ESPACO              : (' ' | '\t');
NOVALINHA           : ('\r'? '\n' | '\r')+;


// RESERVED KEYWORDS
SE                  : 'se';
ENTAO               : 'entao';
SENAO               : 'senao';
END_STATEMENT       : 'es';
EOF                 : 'EOF';