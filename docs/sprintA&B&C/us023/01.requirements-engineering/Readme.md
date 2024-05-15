# US023 - ... 


## 1. Requirements Engineering

### 1.1. User Story Description

As a GSM, I want to assign a Team to an entry in the Agenda.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	...

>	...

**From the client clarifications:**

> **Question:** ...
>
> **Answer:** ...

> **Question:** ...
>
> **Answer:** ...

### 1.3. Acceptance Criteria

* **AC1:** A message must be sent to all team members informing them about the assignment.
* **AC2:** Different email services can send the message. These services must be defined through a configuration file to allow the use of different platforms (e.g. Gmail, DEI’s email service, etc.).
* **ACX:**
* **ACX:** System must ensure that only GSM assigns a Team to an Agenda entry.

### 1.4. Found out Dependencies

* There is a dependency on "US022 - ..." as there must be at least one entry in the agenda.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    *
	
* Selected data:
    * Team
    * Entry in the Agenda

**Output Data:**

* All team data
* Entry in the Agenda
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us023-system-sequence-diagram-alternative-one.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us023-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* n/a