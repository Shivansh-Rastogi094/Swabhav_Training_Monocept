-- 0. Show details of all employees
SELECT * FROM EMP;

-- 1. Display all employee names in ascending order
SELECT ENAME 
FROM EMP 
ORDER BY ENAME ASC;

-- 2. Display all employees (all columns) in department 20 and 30
SELECT * 
FROM EMP 
WHERE DEPTNO IN (20, 30);

-- 3. Display all the employees who are managers
SELECT * 
FROM EMP 
WHERE JOB = 'MANAGER';

-- 4. Display all the employees whose salary is between 2000 and 5000
SELECT * 
FROM EMP 
WHERE SAL BETWEEN 2000 AND 5000;

-- 5. Display all the employees whose commission is null
SELECT * 
FROM EMP 
WHERE COMM IS NULL;

SELECT DEPTNO, COUNT(ENAME) FROM EMP WHERE COMM IS NULL GROUP BY DEPTNO;

select deptname, count(e.deptno) as nullcount from dept d join emp e on d.deptno = e.deptno where e.comm is null group by dname;

-- 6. Display emp_name, salary, commission, CTC (calculated column)
SELECT ENAME, SAL, COMM, (SAL + IFNULL(COMM,0)) AS CTC
FROM EMP;

-- 7. Display hire_date, current_date, tenure (calculated column)
SELECT ENAME, HIREDATE, CURDATE() AS TODAY,
DATEDIFF(CURDATE(), HIREDATE) AS TENURE_DAYS
FROM EMP;

-- 8. Display all the employees whose name starts with 'S'
SELECT * 
FROM EMP 
WHERE ENAME LIKE 'S%';

-- 9. Display unique department numbers from the employee table
SELECT DISTINCT DEPTNO 
FROM EMP;

-- 10. Display emp_name and job in lower case
SELECT LOWER(ENAME) AS NAME, LOWER(JOB) AS JOB
FROM EMP;

-- 11. Select top 3 salary earning employees
SELECT * 
FROM EMP 
ORDER BY SAL DESC 
LIMIT 3;

-- 12. Select clerks and managers in department 10
SELECT * 
FROM EMP 
WHERE DEPTNO = 10 
AND JOB IN ('CLERK', 'MANAGER');

-- 13. Display all clerks in ascending order of department number
SELECT * 
FROM EMP 
WHERE JOB = 'Clerk'
ORDER BY DEPTNO ASC;

-- 16. Display all employees in the same department as 'SCOTT'
SELECT * 
FROM EMP 
WHERE DEPTNO = (
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'
);

-- 17. Employees having same designation as SMITH
SELECT * 
FROM EMP 
WHERE JOB = (
    SELECT JOB FROM EMP WHERE ENAME = 'SMITH'
);

-- 18. Employees who are reporting under KING
SELECT * 
FROM EMP 
WHERE MGR = (
    SELECT EMPNO FROM EMP WHERE ENAME = 'KING'
);

-- 19. Employees who have same salary as BLAKE
SELECT * 
FROM EMP 
WHERE SAL = (
    SELECT SAL FROM EMP WHERE ENAME = 'BLAKE'
);

-- 20. Display department-wise number of employees
SELECT DEPTNO, COUNT(*) AS EMP_COUNT
FROM EMP
GROUP BY DEPTNO;

-- 21. Display job-wise number of employees
SELECT JOB, COUNT(*) AS EMP_COUNT
FROM EMP
GROUP BY JOB;

-- 22. Display dept-wise job-wise number of employees
SELECT DEPTNO, JOB, COUNT(*) AS EMP_COUNT
FROM EMP
GROUP BY DEPTNO, JOB;

-- 23. Display departments having more than 3 employees
SELECT DEPTNO, COUNT(*) AS EMP_COUNT
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) > 3;

-- 24. Display designation-wise employees count greater than 3
SELECT JOB, COUNT(*) AS EMP_COUNT
FROM EMP
GROUP BY JOB
HAVING COUNT(*) > 3;

-- 25. Display employee name, department name and location
SELECT e.ENAME, d.DNAME, d.LOC
FROM EMP e
JOIN DEPT d ON e.DEPTNO = d.DEPTNO;

-- 26. Display all department names and corresponding employees (if any)
SELECT d.DNAME, e.ENAME
FROM DEPT d
LEFT JOIN EMP e ON d.DEPTNO = e.DEPTNO;

-- 27. Display department names where there are no employees
SELECT d.DNAME
FROM DEPT d
LEFT JOIN EMP e ON d.DEPTNO = e.DEPTNO
WHERE e.EMPNO IS NULL;

-- 28. Display dept-wise employee count greater than 3 in descending order of dept name
SELECT d.DNAME, COUNT(e.EMPNO) AS EMP_COUNT
FROM DEPT d
JOIN EMP e ON d.DEPTNO = e.DEPTNO
GROUP BY d.DNAME
HAVING COUNT(e.EMPNO) > 3
ORDER BY d.DNAME DESC;

-- 29. Display all employee names and their manager names
SELECT e.ENAME AS EMPLOYEE, m.ENAME AS MANAGER
FROM EMP e
LEFT JOIN EMP m ON e.MGR = m.EMPNO;

-- 30. Display employee name, department name and manager name as bossname, ordered by bossname
SELECT e.ENAME, d.DNAME, m.ENAME AS BOSSNAME
FROM EMP e
JOIN DEPT d ON e.DEPTNO = d.DEPTNO
LEFT JOIN EMP m ON e.MGR = m.EMPNO
ORDER BY BOSSNAME;

-- 31. Display department name, employee name and their manager names
SELECT d.DNAME, e.ENAME AS EMPLOYEE, m.ENAME AS MANAGER
FROM EMP e
JOIN DEPT d ON e.DEPTNO = d.DEPTNO
LEFT JOIN EMP m ON e.MGR = m.EMPNO;