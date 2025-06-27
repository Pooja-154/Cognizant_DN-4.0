-- Scenario-1 
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        UPDATE Accounts
        SET Balance = Balance + (acc.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;
    END LOOP;
END;

-- Scenario-2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_department VARCHAR2, p_bonus_percent NUMBER) IS
BEGIN
    FOR emp IN (SELECT EmployeeID, Salary FROM Employees WHERE Department = p_department) LOOP
        UPDATE Employees
        SET Salary = Salary + (emp.Salary * p_bonus_percent / 100)
        WHERE EmployeeID = emp.EmployeeID;
    END LOOP;
END;

-- Scenario-3
CREATE OR REPLACE PROCEDURE TransferFunds(p_from NUMBER, p_to NUMBER, p_amount NUMBER) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from FOR UPDATE;

    IF v_balance >= p_amount THEN
        UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from;
        UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to;
    END IF;
END;
