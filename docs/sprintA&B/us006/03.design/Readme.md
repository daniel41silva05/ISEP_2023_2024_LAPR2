# US006 - Register a vehicle 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for... | Answer                     | Justification (with patterns)                                                                                 |
|:---------------|:--------------------- |:---------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | RegisterVehicleUI          | ...                           |
| 		             | 	... coordinating the US?                     | RegisterVehicleControlller | Controller                    |
| Step 2 		      | 	...                                          | ...                        | ...                           |
| Step 3 		      | 	... saving the inputted data?                | Vehicle                    | ...                           |
| Step 4 		      | 	...                                          | ...                        | ...                           |
| Step 5 		      | 	... validating all data (local validation)?  | ...                        | ...                           |
| 		             | 	... validating all data (global validation)? | ...                        | ...                           |
| 		             | 	... saving the registered collaborator?      | ...                        | ...                           |
| Step 6 		      | 	... informing operation success?             | RegisterCollaboratorUI     | ...                           | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* ...
* Vehicle

Other software classes (i.e. Pure Fabrication) identified: 

* RegisterVehicleUI  
* RegisterCollaboratorUI


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us006-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us006-sequence-diagram-split.svg)

**Get Task Category List Partial SD**

![Sequence Diagram - Partial - Get Task Category List](svg/us006-sequence-diagram-partial-get-task-category-list.svg)

**Get Task Category Object**

![Sequence Diagram - Partial - Get Task Category Object](svg/us006-sequence-diagram-partial-get-task-category.svg)

**Get Employee**

![Sequence Diagram - Partial - Get Employee](svg/us006-sequence-diagram-partial-get-employee.svg)

**Create Task**

![Sequence Diagram - Partial - Create Task](svg/us006-sequence-diagram-partial-create-task.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us006-class-diagram.svg)