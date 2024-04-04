# US004 - Assign Skills 


## 1. Requirements Engineering

### 1.1. User Story Description

As an HRM, I want to assign one or more skills to a collaborator.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	Every task is defined by a distinct reference assigned within the organization, accompanied by a designation, both informal and technical descriptions, estimated duration and cost, and a designated task category. 

>	Access to the task is restricted solely to employees of the respective organization until it is published.

**From the client clarifications:**

> **Question:** Can any skill be registered to any collaborator/job? Or should they be associated in categories in association with a specific job
>
> **Answer:** There is no association, it totally depends of the CV of the collaborator.

> **Question:** There is a minimum and maximum number of skills?
>
> **Answer:** No

### 1.3. Acceptance Criteria

* **AC1:** Select an employee from the provided list.
* **AC2:** When the HRM is inputting the number of skills to be added, it must be a non-negative integer.
* **AC3:** The HRM needs to select numbers from the list.

### 1.4. Found out Dependencies

* There is a dependency on "US001" - ...
* There is a dependency on "US003" - ...

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * ...
    * ... 
    * ...
    * ...
    * ...
    * ...
	
* Selected data:
    * ...

**Output Data:**

* List of existing task categories
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us006-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.