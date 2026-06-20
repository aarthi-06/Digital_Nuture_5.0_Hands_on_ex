SET SERVEROUTPUT ON

BEGIN

   FOR rec IN (
      SELECT c.name, l.loan_id, l.due_date
      FROM customers c
      JOIN loans l ON c.customer_id = l.customer_id
      WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
   ) LOOP

      DBMS_OUTPUT.PUT_LINE(
         'Reminder: Dear ' || rec.name ||
         ', your loan ' || rec.loan_id ||
         ' is due on ' || rec.due_date
      );

   END LOOP;

END;
/