Questo è un semplice webservice RESTful di studio per visualizzare/scrivere/aggiornare/cancellare messaggi dei messaggi.

Il progetto è composto da una parte di modello dove sono contenuti i dati a cui il webservice accede ed il servizio stesso che si occupa dei gestire i 4 verb GET, POST, PUT, DELETE.

Per semplicità non sono state gestite exception in questa versione e sono stati fatti solo alcuni controlli su nullpointer.

I prametri utilizzati dal servizio sono i seguenti:
u : il nome dell'utente che manda il messaggio
r : il nome dell'utente che riceve il messaggio
m : il messaggio da inviare
id : l'id del messaggio

N.B.: attualmente sono stati inseriti solo tre utenti: Luca - Giovanni - Marta
Il comportamento non è previsto nel caso si utilizzassero nomi diversi da questi.

Per testare il servizio è possibile fare il deploy del file "testWS.war", situato nella cartella "target", su un webserver in locale, tomcat ad esempio, ed utilizzare i seguenti comandi per le operazioni CURD:

GET:
curl -X GET "http://localhost:8080/testWS"
curl -X GET "http://localhost:8080/testWS/?u=NOMEUTENTE"

POST:
curl -X POST "http://localhost:8080/testWS/?u=NOMEUTENTE&r=NOMEUTENTE&m=MESSAGGIO"

PUT:
curl -X PUT "http://localhost:8080/testWS/?u=NOMEUTENTE&m=MESSAGGIO&id=IDMESSAGGIO"

DELETE:
curl -X DELETE "http://localhost:8080/testWS/?u=NOMEUTENTE&id=IDMESSAGGIO"