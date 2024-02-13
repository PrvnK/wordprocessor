# Word Processor

**Overview**
Word Process application currently contain one core functionality. Application takes one or more string path in input seperated by a comma, process them and prints the word details from the file along with its count in descending order. 

Application is built with Java version 17.


**Assumptions**

- Logic is case sensitive based on provided input and example. Eg:  'the' and 'The' are considered as 2 different words.
 
- Word separators like Dot'.', Comma',', and Semicolon';' are also removed in the process of file processing. 

- If more than one file has to be provided in Command line, then they can be provided as single string seperated by comma. *Eg: C:\Users\prvn\MultitoneAssessment\src\resources\Input1.txt,C:\Users\prvn\MultitoneAssessment\src\resources\Input2.txt*


**Execution steps**
Below are the list of steps for executing from command line:

1. Ensure Java and Maven are installed in the machine and JAVA_HOME is configured in environment variables.

2. Download the project and navigate into the project folder from command line.

3. Run 'mvn clean install' to ensure code is compiled correctly. Note: If any test cases fail, skip them using 'mvn clean install -DskipTests'

4. Run the following command to run the Main class 'WordProcessorApp'. Command:* mvn exec:java -D"exec.mainClass"="com.multitone.main.WordProcessorApp" * <br>
Note: Above command is run for running from windows machine. It might vary for other operating systems.

5. Provide the filepath(s) as input in the console when prompted. Note: It should be fully qualified path. Below are some acceptable file paths: <br>
 	- C:\Users\prvn\eclipse-workspace\App\src\resources\Input.txt <br>
 	- C:\Users\prvn\eclipse-workspace\App\src\resources\Input.txt,C:\Users\prvn\eclipse-workspace\App\src\resources\Input1.txt <br>


<br><br>

---
### Sample Input 

You can relax in a section of the cabin taken from an executive airliner,
complete with cocoa-cream leather sofas and the plushest of swivel armchairs.
Steve Varsano, founder of The Jet Business, runs me through my brand options
if I have an appetite for luxury and at least £10m to spare: the Citation,
Gulfstream or Embraer. But he disputes my description.

### Sample output for above input
 of: 3 
<br> the: 3
<br> my: 2
<br> an: 2
<br> and: 2
<br> through: 1
<br> swivel: 1
<br> section: 1
<br> executive: 1
<br> airliner: 1
<br> me: 1
<br> options: 1
<br> from: 1
<br> brand: 1
<br> if: 1
<br> Embraer: 1
<br> Business: 1
<br> in: 1
<br> disputes: 1
<br> leather: 1
<br> cocoa-cream: 1
<br> at: 1
<br> sofas: 1
<br> armchairs: 1
<br> Gulfstream: 1
<br> for: 1
<br> least: 1
<br> cabin: 1
<br> I: 1
<br> description: 1
<br> Varsano: 1
<br> The: 1
<br> can: 1
<br> spare:: 1
<br> taken: 1
<br> have: 1
<br> Citation: 1
<br> But: 1
<br> a: 1
<br> £10m: 1
<br> or: 1
<br> relax: 1
<br> founder: 1
<br> plushest: 1
<br> with: 1
<br> Steve: 1
<br> Jet: 1
<br> luxury: 1
<br> appetite: 1
<br> to: 1
<br> complete: 1
<br> runs: 1
<br> he: 1
<br> You: 1

---
 	 
 	
 	
 	