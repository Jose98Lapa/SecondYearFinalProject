grammar GramaticaAtividadeAutomatica;

/*
 *   Lexico
 */

gramatica: 'BEGIN' instrucao* 'END';

instrucao: inicializacao
   | expr
   | if_stat
   | atribuicao
   | estrutura_xml
   | enviar_email
   | update_informacao
   ;


tipo_ficheiro: TIPOFICHEIRO identidade
   | TIPOFICHEIRO identidade OPERADORATRIBUICAO '"' NOME_FICHEIRO '"'
   ;

elemento: ELEMENTO identidade
   | ELEMENTO  atribuicao_elemento;

atribuicao_elemento: identidade OPERADORATRIBUICAO 'FIND' '[' (TEXTO|NUMERO)+ ']' 'where' '(' (TEXTO|NUMERO)+ ',' (TEXTO|NUMERO)+ ')'
   ;

inicializacao: TIPODADOS identidade     #inicializacaoIdent
   | TIPODADOS atribuicao               #inicializacaoAtribuicao
   ;

atribuicao: identidade OPERADORATRIBUICAO expr                          #variavelExpr
    | identidade OPERADORATRIBUICAO identidade'(' (TEXTO|NUMERO)+ ')'   #variavelVariavel
   ;

/*expr: expr op tipo_dados
   | identidade OPERADORATRIBUICAO expr
   ;
*/

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

estrutura_xml: tipo_ficheiro
               elemento+
               END_FICHEIRO
               ;

enviar_email: SEND_EMAIL '(' identidade ',' identidade ',' identidade')'
              ;

update_informacao: UPDATE '(' (TEXTO|NUMERO)+  ','  (TEXTO|NUMERO)+ ',' (TEXTO|NUMERO)+ ')' '->' '(' (TEXTO|NUMERO)+ ',' identidade ')'
              ;
/*
estrutura_condicional: ife
                       elsee?
                       END_SE
                       ;

ife               : SE condicao (OPERADORLOGICO_EC condicao)* ENTAO
                      instrucao+
                      ;

condicao: expr;

elsee               : SENAO
                      instrucao+
                      ;

*/

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
