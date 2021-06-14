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


estrutura_xml: tipo_ficheiro
               elemento+
               END_FICHEIRO
               ;

tipo_ficheiro: TIPOFICHEIRO identidade                   #ficheiroIdent
    | TIPOFICHEIRO identidade OPERADORATRIBUICAO STRING  #ficheiroNomeFicheiro
    ;

elemento: ELEMENTO identidade
    | ELEMENTO  atribuicao_elemento;

atribuicao_elemento: nomeVar=identidade OPERADORATRIBUICAO 'FIND' '[' what=(TEXTO|NUMERO)+',' file=identidade ']' 'where' '(' id=(TEXTO|NUMERO)+ ',' idvalue=(TEXTO|NUMERO)+ ')'
    ;

inicializacao: TIPODADOS identidade         #inicializacaoIdent
    | TIPODADOS atribuicao                  #inicializacaoAtribuicao
    ;

atribuicao: identidade OPERADORATRIBUICAO expr                          #variavelExpr
    | nomeVar=identidade OPERADORATRIBUICAO nomeElemento=identidade'(' what=(TEXTO|NUMERO)+ ')'   #variavelVariavel
    ;

if_stat: SE condition_block (SENAO stat_block)? END_SE
    ;

condition_block
    : expr ENTAO stat_block
    ;

stat_block
    :  instrucao*
    ;


expr: atom  = tipo_dados                                   #atomExpr
    | left=expr POW right=expr                             #powExpr
    | left=expr op=(MULT | DIV | MOD) right=expr           #mulDivModExpr
    | left=expr op=(MAIS | MENOS) right=expr               #sumDifExpr
    | left=expr op=(LTEQ | GTEQ | LT | GT) right=expr      #relationalExpr
    | left=expr op=(EQ | NEQ) right=expr                   #equalExpr
    | left=expr E right=expr                               #andExpr
    | left=expr OU right=expr                              #orExpr
    ;

tipo_dados: identidade  #tp_ident
    | integer           #tp_integer
    | floate            #tp_float
    | string            #tp_float
    ;

integer
    : '-'? NUMERO
    ;

floate
    : '-'? REAL
    ;

identidade
    : VARIAVEL
    ;

string
    : STRING
    ;


enviar_email: SEND_EMAIL '(' destinatario=identidade ',' assunto=identidade ',' corpo=identidade')'    #emailAtributos
            | SEND_EMAIL '(' destinatario=identidade ',' assunto=STRING ',' corpo=STRING')'            #emailString
            ;

update_informacao: UPDATE '(' (TEXTO|NUMERO)+  ','  (TEXTO|NUMERO)+ ',' (TEXTO|NUMERO)+ ')' '->' '(' (TEXTO|NUMERO)+ ',' identidade ')'
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
ELEMENTO            : 'ELEMENTO';

TIPOFICHEIRO           : 'XML';
END_FICHEIRO           : 'LMX';
SEND_EMAIL             : 'ENVIAR_EMAIL';
UPDATE                 : 'ATUALIZAR';


NUMERO              : DIGITO+;
REAL                : DIGITO+ ( [.,] DIGITO+ )?;
NOME_FICHEIRO       : (TEXTO|NUMERO)+  '.' TEXTO ;
TEXTO               : (( UPPERCASE )?( LOWERCASE ))+;
STRING              : '"' ~('"')+ '"';

COMMENT: '/*' .*? '*/' -> skip
;
COMMENTLINE: '//' ~[\r\n]* -> skip
;
ESPACO              : [ \t\r\n]+ -> skip ;
