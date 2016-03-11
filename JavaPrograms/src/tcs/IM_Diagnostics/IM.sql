1.Create the DB structure (two tables)
CREATE TABLE TBL_Employee_CT20141173457
(
Employee_Id NUMBER(4) NOT NULL PRIMARY KEY,
Name VARCHAR2(30),
Designation VARCHAR2(30),
Age NUMBER(3)
)

CREATE TABLE TBL_Claim_CT20141173457
(
Claim_Id NUMBER(4) NOT NULL PRIMARY KEY,
Claim_Details VARCHAR2(100),
Claim_Amt NUMBER(7, 2),
Employee_Id NUMBER(4) FOREIGN KEY REFERENCES TBL_Employee_CT20141173457(Employee_Id)
)


/* Insert the Data in the above tables using the below scripts */
insert into tbl_employee_CT20141173457 values (2000,'Raj','Manager',35)
insert into tbl_employee_CT20141173457 values (1245,'Krishna','VicePresident',45) 
insert into tbl_employee_CT20141173457 values (4321,'Thomas','Associate',25) 
insert into tbl_employee_CT20141173457 values (2451,'Varun','Manager',30)
insert into tbl_claim_CT20141173457 values (7471,'Medical',2000,1245) 
insert into tbl_claim_CT20141173457 values (7215,'Dental',1000,2451) 
insert into tbl_claim_CT20141173457 values (7310,'Hospital',10000,2000) 
insert into tbl_claim_CT20141173457 values (7420,'Medical',5000,2000)


2. Write SQL Query to retrieve the Employee Names in descending order of their Age. 
	
	SELECT Name 
	FROM tbl_employee_CT20141173457 
	ORDER BY Age 
	DESC;


3. Write SQL Query to display the total Claim Amts of each employee along with the employee Id 

	SELECT Employee_Id, sum(Claim_Amt) 
	FROM tbl_claim_CT20141173457 
	GROUP BY Employee_Id

	
4. Write SQL Query  to display the list of claim and employee details whose claim amount is greater 1500

	SELECT *
	FROM tbl_employee_CT20141173457
	INNER JOIN tbl_claim_CT20141173457
	ON tbl_employee_CT20141173457.Employee_Id = tbl_claim_CT20141173457.Employee_Id
	WHERE tbl_claim_CT20141173457.Claim_Amt > '1500';
 
 
5. Write SQL Query to display the employee name who do not have any claim.
	SELECT Name
	FROM   tbl_employee_CT20141173457
	WHERE  NOT EXISTS
	(SELECT *
	FROM   tbl_claim_CT20141173457
	WHERE  tbl_employee_CT20141173457.Employee_Id = tbl_claim_CT20141173457.Employee_Id);
