# US028 - Consult the Task Between Two Dates

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                 | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:-----------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | ConsultTasksUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | ConsultTasksController | Controller                                                                                                    |
| 			  		        | ... knowing the user using the system?        | UserSession            | IE: cf. A&A component documentation.                                                                          |
| Step 2  		     | 	... selects two dates 						                 | Collaborator           |                                                                                                               |
| 			  		        | 	... showing all available tasks              | Agenda                 | Creator (Rule 1): in the DM Organization has a Task.                                                          |
| Step 3  		     | 	...validating the inserted date?             | Agenda                 | IE: Task Categories are defined by the Administrators.                                                        |
| Step 4  		     | 							                                       |                        |                                                                                                               |              
| Step 5  		     | 	... validating all data (local validation)?  | Entry                  | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | Agenda                 | IE: knows all its tasks.                                                                                      | 
| Step 6  		     | 	... informing operation success?             | ConsultTasksUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Entry
* Agenda
* Collaborator

Other software classes (i.e. Pure Fabrication) identified: 

* ConsultTasksUI  
* ConsultTasksController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us028-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us028-sequence-diagram-split.svg)

**Get Task Category List Partial SD**

![Sequence Diagram - Partial - Get Task Category List](svg/us028-sequence-diagram-partial-get-collaborator.svg)

**Get Task Category Object**

![Sequence Diagram - Partial - Get Task Category Object](svg/us028-sequence-diagram-partial-sort-tasks.svg)

**Get Employee**

![Sequence Diagram - Partial - Get Employee](svg/us028-sequence-diagram-partial-get-sorted.entry.lists.svg)

**Create Task**

![Sequence Diagram - Partial - Create Task](svg/us006-sequence-diagram-partial-create-task.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us028-class-diagram.svg)