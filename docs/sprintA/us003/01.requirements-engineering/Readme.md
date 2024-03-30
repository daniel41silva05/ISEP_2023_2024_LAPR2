# US003 - Register collaborator with job and fundamental characteristics


## 1. Requirements Engineering

### 1.1. User Story Description

As an HRM, I want to register a collaborator with a job and fundamental characteristics.


### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

>   Human resources manager fills in all fields for collaborator registration.

>	Each collaborator is characterized by having a unique name, a birthday, a date of admission, an adornment, a type of identification document and a number, as well as two contact details (mobile phone and email).

>	The job will be chosen from the list of jobs registered in US02.

**From the client clarifications:**

> **Question:** Does the HRM select the job from a list that we display?
>
> **Answer:** Displaying or not, It's a matter of UX, the dev team should decide about it, but the valid jobs are the ones created within the US02.

> **Question:** Should the system able the HRM to insert multiple collaborators in one interaction before saving them?
>
> **Answer:** It's not required to do so.

> **Question:** 
> - Is there any limitation regarding the length of the name of the collaborator?
> - Should we consider valid only the birthdates in which the collaborator has more than 18 years?
> - What should be the format for the phone number? 9 numbers?
> - What is the format for the numbers from the id doc types?
>
> **Answer:**
> - According to the Portuguese law a name should contain at maximum six words;
> - yes;
> - validating 9 digits will be acceptable; validating with international format would be excelent;
> - each doc type has specific formats like taxpayer number, Citizen Card ou passport.

> **Question:** What is needed for the adress ?  Street, zipcode and a city?
>
> **Answer:** That would be enough.

### 1.3. Acceptance Criteria

* **AC01:** Full Name, birthdate, admission date, address, contact info (mobile and email), ID doc type and respective number should be provided by HRM.
* **AC02:** All mandatory fields must be filled in.
* **AC03:** Full name can only contain 6 words, consisting only of letters and spaces between each one.
* **AC04:** Birthdate and submission data can only contain numbers and must follow the format provided.
* **AC05:** Birthdate must be 18 years older than the current date.
* **AC06:** Residence must be written including: street, zipcode (must contain numbers and respect the format "xxxx-xxx") and city.
* **AC07:** Phone number must have "+" followed by 3 numbers and then 9 numbers or just 9 numbers.
* **AC08:** Email cannot contain spaces and must contain "@".
* **AC09:** User will select an identification document type from a list.
* **AC11:** ID doc number can only -------
* **AC12:** User will select a job from the list of jobs registered in US02.
* **AC13:** Collaborator must not have a registered account

### 1.4. Found out Dependencies

* There is a dependency on "US002 - Register a Job" as there must be at least one job to assign the employee to be registered.

### 1.5 Input and Output Data

**Input Data:**
 ID doc type
* Typed data:
  * Name
  * Birthday
  * Admission Date
  * Address
  * Phone Number
  * Email
  * ID Number

* Selected data:
  * List of ID doc Types
  * List of Jobs

**Output Data:**

* All data of the new registered employee
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us003-system-sequence-diagram-alternative-one.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us003-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* ...