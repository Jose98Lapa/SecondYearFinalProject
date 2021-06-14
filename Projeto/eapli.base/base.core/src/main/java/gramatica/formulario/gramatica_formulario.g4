grammar gramatica_formulario;

/*
 *   Lexico
 */

gramatica: 'BEGIN' instrucao+ 'END';

instrucao: inicializacao
   | expr
   | if_stat
   | atribuicao
   ;

inicializacao: TIPODADOS identidade     #inicializacaoIdent
   | TIPODADOS atribuicao               #inicializacaoAtribuicao
   ;

atribuicao: identidade OPERADORATRIBUICAO expr                          #variavelExpr
    | identidade OPERADORATRIBUICAO identidade'(' (TEXTO|NUMERO)+ ')'   #variavelVariavel
   ;

expr: left=expr POW right=expr                          #powExpr
 | left=expr op=(MULT | DIV | MOD) right=expr           #mulDivModExpr
 | left=expr op=(MAIS | MENOS) right=expr               #sumDifExpr
 | left=expr op=(LTEQ | GTEQ | LT | GT) right=expr      #relationalExpr
 | left=expr op=(EQ | NEQ) right=expr                   #equalExpr
 | left=expr E right=expr                               #andExpr
 | left=expr OU right=expr                              #orExpr
 | atom  = tipo_dados                                   #atomExpr
 ;

tipo_dados: identidade #tp_ident
   | integer           #tp_integer
   | floate            #tp_float
   | stringe           #tp_stringe
   ;

integer
   : '-'? NUMERO
   ;

floate
   : '-'? REAL
   ;

stringe
   : '"' TEXTO '"'
   ;

identidade: VARIAVEL
   ;

if_stat: SE condition_block (SENAO stat_block)? END_SE
 ;

condition_block
 : expr ENTAO stat_block
 ;

stat_block
 :  instrucao*
 ;

fragment DIGITO     : [0-9];
fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];

OU : 'ou';
E : 'e';
EQ : '=';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
MAIS : '+';
MENOS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : '!';
OPERADORATRIBUICAO  : '->';

VARIAVEL            : '$' (TEXTO) [_]? (TEXTO | NUMERO )*;

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
NOME_FICHEIRO       : (TEXTO|NUMERO)+  '.' TEXTO ;
TEXTO               : (( UPPERCASE )?( LOWERCASE ))+;

COMMENT: '/*' .*? '*/' -> skip
;
COMMENTLINE: '//' ~[\r\n]* -> skip
;
ESPACO              : [ \t\r\n]+ -> skip ;
