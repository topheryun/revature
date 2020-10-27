select employee.name, projects.ordernumber 
from employee
inner join projects on employee.id=projects.id;