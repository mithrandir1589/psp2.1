C�digo asignatura: 201710_CSOF5101_01
Nombre Asignatura: Conceptos avanzados de ingenier�a de software
Tarea 5: Program 5
Nombre estudiante: Miguel �ngel Quintero Pi�eros
Fecha de env�o: 05 Abril 2017
**********************************************************************

Instrucciones ejecuci�n programa: 
1. Ingrese a simbolo de sistema (Tecla inicio + cmd + Enter)

2. Ubicarse en la ruta en la cual est� el archivo Program5.jar psp2.1\src\main\java\src (Carpeta del proyecto descargada de gitHub) o Program 5 PSP_Miguel Quintero\src (.zip subibo a sicua)
3. Ejecutar el comando java -jar Program5.jar y pulsar la tecla Enter
4. Ingresar los datos para x, grados de libertad, tolerancia y la cantidad de segmentos.
5. Visualizar el resultado del calculo de p en la ventana de S�mbolo de Sistema 	     

***************************************************************************
Ruta de los directorios pspdata, pspforms y test 
GitHub:https://github.com/mithrandir1589/psp2.1/tree/master/src/site/resources/PSP2.1
Carpeta: ..\Program 5 PSP_Miguel Quintero


Nota: Teniendo en cuenta las instrucciones para esta tarea, la estructura del .zip contiene los directorios psp data, psp forms, src, test y readme
Por otro lado el repositorio en GitHub contiene la estructura acostumbrada en GIT src, target, .gitignore, LICENCE.txt, pom.xml y README.xml 
***************************************************************************

ruta del repositorio en gitHub https://github.com/mithrandir1589/psp2.1

ruta de la aplicaci�n desplegada en heroku https://polar-harbor-49438.herokuapp.com/psp2.1

***************************************************************************
Para empaquetar el programa con Maven, se debe ejecutar la sentencia "mvn package" en la carpeta ra�z de donde se haga el pull del
repositorio git, la cual es la que se descargar� desde el repositorio GitHub y donde se encuentra el pom.xml. Para correr las pruebas unitarias usando maven, es necesario correr el comando
mvn -Dtest=Pruebas test , donde Pruebas es la clase con las pruebas en JUnit. 

ACLARACION: La clase calculos es la que tiene todos los m�todos l�gicos, en total son 8, pero teniendo en cuenta que solamente hay dos m�todos de acceso p�blico, Calculos() y getP(),
y que solamente getP() retorna valores, a este �ltimo fue al �nico m�todo que se pudo codificar pruebas unitarias usando JUnit. Se ejecutaron 3 pruebas en los cuales el resultado esperado 
era el calculo correcto del valor p. En las pruebas se usa el constructor de la clase Calculos ya que este es el encargado de invocar a todos m�todos encargados de hacer los diferentes 
calculos, para finalmente llegar al calculo de p.