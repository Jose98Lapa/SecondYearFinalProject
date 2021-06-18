grammar GramaticaFormulario;

/*
 *   Lexico
 */

gramatica: 'BEGIN' instrucao+ 'END';

instrucao: inicializacao
   | expr
   | if_stat
   | atribuicao
   | atribuicao_atributo
   | fail
   | matchregex
   | matchregexatribut
   ;

fail:FAIL #validationFail
| PASS  #validationPass
;

inicializacao: tipoDados = TIPODADOS identidade     #inicializacaoIdent
   | tipoDados = TIPODADOS atribuicao               #inicializacaoAtribuicao
   ;

atribuicao_atributo: inicializacao OPERADORATRIBUICAO get_atributo;

get_atributo: 'atr' '[' numero=NUMERO ']' #atr_atributo
  ;

matchregex: MATCHREGEX '[' var=VARIAVEL ',' regex =  REGEX ']' #match_regex
;

matchregexatribut :MATCHREGEX '[' get_atributo ',' regex = REGEX ']' #match_regex_atribut
;

atribuicao: iden =identidade OPERADORATRIBUICAO expr                     #variavelExpr
    | identidade OPERADORATRIBUICAO identidade '(' (TEXTO|NUMERO)+ ')'   #variavelVariavel
    | identidade OPERADORATRIBUICAO get_atributo                         #variavelAtr
   ;

expr: left=expr POW right=expr                          #powExpr
 | left=expr op=(MULT | DIV | MOD) right=expr           #mulDivModExpr
 | left=expr op=(MAIS | MENOS) right=expr               #sumDifExpr
 | left=expr op=(LTEQ | GTEQ | LT | GT) right=expr      #relationalExpr
 | left=expr op=(EQ | NEQ) right=expr                   #equalExpr
 | left=expr op=E right=expr                               #andExpr
 | left=expr op=OU right=expr                              #orExpr
 | atom  = tipo_dados                                   #atomExpr
 ;

tipo_dados: identidade #tp_ident
   | integer           #tp_integer
   | floate            #tp_float
   | STRING            #tp_stringe
   | data              #tp_data
   ;

integer
   : '-'? NUMERO
   ;

floate
   : '-'? REAL
   ;

data
   : '"' DATAREGEX '"'
   ;

identidade: var=VARIAVEL #variavel
   ;

if_stat: SE  condition_block (senao_rule stat_block)? END_SE #if
 ;

senao_rule : SENAO #senao;

entao_rule : ENTAO #entao
;

condition_block
 : expr entao_rule stat_block
 ;

stat_block
 : instrucao*
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
FAIL : 'FAIL';
PASS : 'PASS';
MATCHREGEX : 'matchRegex';
OPERADORATRIBUICAO  : '->';

VARIAVEL            : '$' ([a-zA-Z_]+) [_]? ([a-zA-Z_]+ | NUMERO )*;

// RESERVED KEYWORDS
SE                  : 'se';
ENTAO               : 'entao';
SENAO               : 'senao';
END_SE              : 'es';

TIPODADOS           : 'NUMERO' | 'REAL' | 'TEXTO' | 'DATA';
ELEMENTO           : 'ELEMENTO';

NUMERO              : DIGITO+;
REAL                : DIGITO+ ( [.,] DIGITO+ )?;
NOME_FICHEIRO       : (TEXTO|NUMERO)+  '.' TEXTO ;
TEXTO               : (( UPPERCASE )?( LOWERCASE ))+;
STRING              : '"' STR  '"';
fragment STR        : ~('"')+ | ;
REGEX               :'@@' .*? '@@';

DATA_DIA            : [0]?[1-9]|[12][0-9]|[3][01];
DATA_MES            : [0]?[1-9]|[1][012];
DATA_ANO            : DIGITO DIGITO DIGITO DIGITO;
DATAREGEX           : DATA_DIA '/' DATA_MES '/' DATA_ANO;


COMMENT: '/*' .*? '*/' -> skip
;
COMMENTLINE: '//' ~[\r\n]* -> skip
;
ESPACO              : [ \t\r\n]+ -> skip ;
