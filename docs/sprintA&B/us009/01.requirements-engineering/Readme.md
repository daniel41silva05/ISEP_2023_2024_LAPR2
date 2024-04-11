# US009 - Managment of Water Consumption


## 1. Requirements Engineering

### 1.1. User Story Description

As a GSM, I want to know the exact costs referring to water
consumption of specific green space so that I may manage these expenses efficiently.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	The file ”WaterUsed.csv” contains records of the ”Park Identification”, ”Year”, ”Month”, ”Day”, ”Consumption”. 

>	The park identification should be through an ID. 

>   The amount paid for water is 0.7 AC/m3, up to a consumption of 50 m3, with a fee of 15% added for higher consumption
levels.

**From the client clarifications:**


> **Question:** 
> The file ”WaterUsed.csv” should be given by the user?
> **Answer:** 
> Yes, the .csv file will be available in the next few days.

> **Question:** 
>When the user enters the park identification, should this be by name or through an ID?
> **Answer:** 
> Users will answer the survey but anonymously.

### 1.3. Acceptance Criteria

* **AC1:** All required fields must be filled in.
* **AC2:** If the park ID does not exist, the system inserts an error message.
* **AC3:** The system will not accept duplicate identifications of the park entered by the user.

### 1.4. Found out Dependencies

* There is no dependency.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * A file given by the user with ”Park Identification”, ”Year”, ”Month”, ”Day” and ”Consumption”.
    * Numbers of parks to be analyzed.
    * 
    

[//]: # (	)
[//]: # (* Selected data:)

[//]: # (    * a task category )

**Output Data:**

* (In)Success of the operation.
* Barplot representing monthly water consumption.
* Statistical analysis and comparison between the park with the highest and lowest water consumption.

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

[//]: # (![System Sequence Diagram - Alternative One]&#40;svg/us006-system-sequence-diagram-alternative-one.svg&#41;)

#### Alternative Two

[//]: # (![System Sequence Diagram - Alternative Two]&#40;svg/us006-system-sequence-diagram-alternative-two.svg&#41;)

### 1.7 Other Relevant Remarks

[//]: # (* The created task stays in a "not published" state in order to distinguish from "published" tasks.)