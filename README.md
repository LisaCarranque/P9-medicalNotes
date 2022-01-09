# P9-medicalNotes

Ce module est un microservice Rest API dédié à la gestion des notes.

Test de l’application :

Tests unitaires :  
Lancer les tests unitaires du module avec l’instruction gradle build.  
Le rapport de couverture de code par les tests est disponible au directory :
build/jacocoHtml/index.html

Tests des microservices :
Ouvrir Postman et tester les endpoints suivants : 

Méthodes Post :
Ajouter les notes :
172.23.0.6:8082/patientHistory/add  
{
"id": "61d875246ba5be5c1c266256",
"content":"Patient states that they are 'feeling terrific' Weight at or below recommended level",
"uuid": "237e9877-e79b-12d4-a765-321741963000"
}  

172.23.0.6:8082/patientHistory/add  
{
"content":"Patient states that they are feeling a great deal of stress at work Patient also complains that their hearing seems Abnormal as of late",
"uuid": "237e9877-e79b-12d4-a765-321741963001"
}

172.23.0.6:8082/patientHistory/add    
{
"content":"Patient states that they have had a Reaction to medication within last 3 months Patient also complains that their hearing continues to be problematic",
"uuid": "237e9877-e79b-12d4-a765-321741963001"
}

172.23.0.6:8082/patientHistory/add  
{
"content":"Patient states that they are short term Smoker",
"uuid": "237e9877-e79b-12d4-a765-321741963002"
}  

172.23.0.6:8082/patientHistory/add  
{ 
"content":"Patient states that they quit within last year Patient also complains that of Abnormal breathing spells Lab reports Cholesterol LDL high",
"uuid": "237e9877-e79b-12d4-a765-321741963002"
}  
 
172.23.0.6:8082/patientHistory/add
{
"content":"Patient states that walking up stairs has become difficult Patient also complains that they are having shortness of breath Lab results indicate Antibodies present elevated Reaction to medication",
"uuid": "237e9877-e79b-12d4-a765-321741963003"
}

172.23.0.6:8082/patientHistory/add  
{
"content":"Patient states that they are experiencing back pain when seated for a long time",
"uuid": "237e9877-e79b-12d4-a765-321741963003"
}  

172.23.0.6:8082/patientHistory/add  
{
"content":"Patient states that they are a short term Smoker Hemoglobin A1C above recommended level",
"uuid": "237e9877-e79b-12d4-a765-321741963003"
}  

172.23.0.6:8082/patientHistory/add  
{
"content":"Patient states that Body Height, Body Weight, Cholesterol, Dizziness and Reaction",
"uuid": "237e9877-e79b-12d4-a765-321741963003"
}  

Mettre à jour une note :    
172.23.0.6:8082/patientHistory/update  
Json : 


Méthodes Get :    
Récupérer la liste des notes d'un patient à partir de son uuid :  
172.23.0.6:8082/patientHistory/findNotesByUuid/237e9877-e79b-12d4-a765-321741963000
