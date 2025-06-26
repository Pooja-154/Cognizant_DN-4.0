-- Scenario-1
DECLARE
    age NUMBER;
BEGIN
    FOR rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Updated interest rate for Customer ID: ' || rec.CustomerID);
        END IF;
    END LOOP;
END;

-- Scenario-2
BEGIN
    FOR cust_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Customer ID ' || cust_rec.CustomerID || ' marked as VIP');
        END IF;
    END LOOP;
END;

-- Scenario-3
DECLARE
    v_customer_name VARCHAR2(100);
BEGIN
    FOR loan_rec IN (
        SELECT CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        SELECT Name INTO v_customer_name
        FROM Customers
        WHERE CustomerID = loan_rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Reminder: ' || v_customer_name || '''s loan is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;

