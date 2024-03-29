# fragmaData2018

<img src="images/fd1.png" width="1000" >
-----------
<img src="images/fd2.png" width="1000" >
-----------
Question 1 :
------------
<img src="images/q1.png" width="1000" >
-----------
Question 2 :
------------
<img src="images/q2.png" width="1000" >
-----------
Question 3 :
------------
<img src="images/q3.png" width="1000" >
-----------
Question 4 :
------------
<img src="images/q4.png" width="1000" >
-----------
UML Representiation:
-----------
<img src="images/fragmaooad.png" width="1000" >
-----------
Interview experience with Fragma Data , Bangalore  

I believe this post is going to be helpful to a lot of people looking to work at start-ups and particularly at Fragma Data , since this company does not have a glassdoor page , nor any google- able past questions / answers to help a candidate know what expect  … 

Read it like a story from top to bottom … it’ll be the most fun that way…  :)   

So here goes….. 
---------------------------------------------------------------------------
Profile : Fragma Data Systems [ Java developer ( 0-1) year’s experience ) 
( Duration of the whole interview process  : august 9 – august 31 ) 
The job  is generally put up on websites like naukri / indeed which get a few thousand applications …  ( about 6 -8 thousand on naukri itself , as far as I can recollect ) 
Next , after a few days ( maybe a week ) your resume is viewed , and if they think it’s  good enough ,  you get a mail ….
If you’re  shortlisted after the resume screening , this is the type of mail you can expect to get : 
---------------------------------------------------------------------------
Hello,
Greetings from Fragma Data Systems.
Thanks for showing interest in the role of Software Engineer - Java Developer.
At Fragma, we follow the below 2 Stage process for selecting our future colleagues;
Stage 1: Coding Problem Test
We send you a coding problem. You have to attempt the solution as per the Instructions in the document attached and get back to us within the designated time.
We are looking at approach as well as solution and both would be marked mutually exclusive.
Stage 2: The Interview
Once the coding test solutions are received, we would take 4 days to evaluate them and rate the approach and solutions.
Based on the rating secured , individuals would get a chance to attend the interview ( Direct / Telephonic / Skype based on mutual convenience ).
Interview would be rated separately. The candidates who have performed the best in both stages would be extended an offer to work along side our development team.
As part of Stage 1 in the process; please find attached coding problem. You'd have to come back with your solutions before 8 PM, 12th August, 2018 for it to be considered.
Please follow the instruction in the document for coding & output.
NOTE: Your solution should be mailed in the following format:

1) Subject of the mail should be : Solution for Coding Problem- JVD201803-   "YOUR NAME" . 
The Solution would not be reviewed if the above subject line is not used in solution mail.
2) Please attach your Solution and Resume to the mail.
3) Please attach the code output in any file format or a screenshot
Please ensure the above 3 points are followed for us to receive & evaluate your solution.
P.S. Note that in case you do not receive any intimation from us within 10 days  after you send us the solution, please consider it as you have not been shortlisted.
Best Regards
-- 
Recruitment Team
Fragma Data Systems
---------------------------------------------------------------------------
So I did 3 out of the 4 questions in the stipulated time , while ensuring that the solution followed the Model , View , Controller design pattern …. and proper package structure wherever  required  and wrote modular code ….
About 8 days pass… and I get a call from the fragma data team ….
The coordinator and I mutually fix an interview time for the next day … in the afternoon …
But then I didn’t get a call till the evening , so I asked the  coordinator on whatsapp as  to when I can expect the call …
He said , it won’t happen that day … maybe tomorrow or day after…
I said fine ….
Finally after 2 days the coordinator confirmed if I was free for the tech interview at 4pm , and I told him I’m free..
It was a conference call with 2 guys on the other side …

1st guy : Hello ( my name ) I’m ( his name ) and I have ( the other guys name) with me on this call….

Me : Hi , nice to talk to you … 

1st guy : So , (my name ) , you have written code for the assignment yourself right …. 

Me : yes , of course *chuckling …* 

1st guy : Ok , so ( My name ) could you open up the assignment and explain the approach you took  for solving the 1st question 

Me : Of course , So as the question says …. Print the :  Top 4 teams which elected to field first after winning toss in the year 2016 2017

First Defined all the classes and interfaces and all using OOD ( Uml ) and after all the structure was defined , I looked at the first criteria …
 Teams which elected to field first after winning toss …
So I segmented out the names of  all the teams that elected to field first after winning the toss …  ( that was the base validation criteria ) 
After that among all the teams filtered out , I scanned for all the matches which involved that team name and if the team’s name was among the winning team for the given year meeting the validation criteria ,  I incremented the teams win count ….and finally put the team objects it in a priority queue ( which was a max heap ) so the team with the maximum count could be popped from the top … and popped out the top 4. 

1st guy:  ok great ! Got it  ! so , you mentioned that you used a priority queue , could you explain how the priority queue is internally implemented ? 

Me : Well , there are a lot of ways to implement a priority queue , as its an ADT, although I’m not completely sure of how Java implements it , I do know it flows the max-heap or min- heap data structure internally ( as per your requirement that’s stated at the creating of the priority queue ) and the minimum / maximum value bubble to the top …  and can be  popped off using poll / or pop operation … and the worst time complexity is guaranteed to be O (Log n)

Interviewer: Ok , so what happens to the rest of the elements when an element is popped from the top of a priority queue .

Me : Well depeding on wheather it’s a max heap or a min heap the maximum/ minimum element respectively is removed from the top , and the next max/ min element bubbles up to the top.
Interviewer: So what can be said about the other elements in the priority queue , are they too arranged increasingly / decreasingly 

Me : no,  a priority queue does not guarantee that , it’s only concerned with the top most element… else if sorting took place every time , the time guarantee of log n would not be there it would be ( N log n   )

Interviewer: ok ! got it !   So ( my name) you’ve used hash maps a lot … do you know how hash maps work internally ? Could you describe it’s implementation? 

Me : Sure , so in hashing, what you internally have is an array , and in java it’s  length is a power of two … so when you start out it’s 16  in length, and the next aspect is the hashing that happens, so a hash function generates  a number , which is assigned to every object and that is what is used to assign the object to an index in the  hash array …. And every index of  that hash array has a list … where the object is stored … 

Interviewer: ok , so what happens if 2 objects say are hashed to the same index 

Me: Well as the index has a list , it’s just inserted as an element in that index list … However , I should also point out that java’s implementation of the hash map and hash set is efficient enough to avoid all that as much as possible as the hashes are random enough to ensure we get a wide distribution of hashes … 

Interviewer: So , what happens when this hash array fills up  …

Me : At that point  rehashing operation  happens , where an array with a higher multiple of  2 array  ( so if it was earlier 16 , now the size becomes 32 ) is created , and the elements in the original array are rehashed and distributed randomly and uniformly in the new array … 

Interviewer: Ok right , So ( my name ) you’ve used abstract classes and interfaces in your code … Could you explain what an abstract class is … and what in interface is 

Me ; yeah , an abstract class is an abstract implementation of an idea, you don’t want to initiate , but whose methods and fields are common for the concrete classes you intend to implement …and Interfaces on the other hand are used to implement functionality to a class , so if you want to add the validation functionality , a good example would be the use I made of the Criteria interface in the assignment ,

Interviewer : Yes,  ok, so are interfaces and abstract classes the same … 
Me : no , well the only thing same about them is that both can’t be initiated , else everything about them is different , for example , an abstract class can have abstract as well as non abstract methods and variables with a  public / default  access  modifier … whereas , an interface can only have a public static final variable …. and public unimplemented methods , but however , I’ll add that from Java 7 , you can define the method as default and provide a body to it … but then  if the triangle problem happens ( i.e if 2 interfaces having the same function name are part of the same class ) then you mandatorily need to redefine that particular function ....

Interviewer : I got it , alright !! So, (my name)  an abstract class is called abstract because it’s got abstract methods in it … So what if it has no abstract methods in it …. 

Me : It’s not a necessity for an abstract class to have abstract methods, you can even have no abstract methods 

Second Interviewer :  So, what my colleague is trying to ask is that , say if there are no abstract method’s in an abstract class, can it be initialized … 

Me : not at all … A class is declared an Abstract class primarily because it’s intended to never be initialized … It’s an abstract representation of something concrete , and It can’t be initialized to a concrete thing , as it’s abstract …  only the classes that extend it , can be initialised , as they’re concrete …. 

Second interviewer : ok ! Great 

First interviewer : There are 2 type of polymorphic behaviors that’s seen in java right … what are they .. 

Me : yeah so there’s runtime polymorphishm and compile time polymorphism ..

Interviewer : So type of polumorphism happens when you called the validate criteria in you methods … 

Me : That was runtime polymorphism in action , as at runtime , the interface provided a generic validate function , but at runtime the specific function body of valide as per the class that was invocated was executed ….

Interviewer : Ok , so I see you’ve used Model View Controller packages in your project … What is that all about ? 

Me : That’s a design pattern , which is used to segment out logically similar things togethere , so that it’s easier to maintain and debug the code,… so the model package had all the classes of  the modelled objects like team , player , etc ….
View was mainly concerned with the presentation aspect , so it just got the results and displayed it …
Controller had the main business logic , all the questions that were there in the assignment could be mapped to a single or multiple functions in the controller package ….

Interviewer: Fine ! 

Second Interviewr : Have you heard of the Singleton design pattern 

Me :Yes , if you ever need just one instance of an object , you can define it’s constructur private and use a static method instead to create a single instance of this class …

Second Interviwere : Right , so have you ever used it in any project ? 

Me : No not really ,  I never came across a scenario where I had to use it … 
Second Interviewer : Ok ! 

Interviwer : Alright , great … It seems we’re done here ( my name )  ! Do you have any questions for us …

Me : * here I simply asked about their association with microsoft , how many days a week they work , what was their revenue model , what all industries they catered to… etc … * 

Interviewer : Ok ( my name ) it was nice talking to you thank you for your time and you can expect a call from the HR in a couple of days ..

Me : It was a pleasure talking to the both of  you too …have a nice day ! 

                         ------------------ END OF PHONE CALL ---------------------- 



