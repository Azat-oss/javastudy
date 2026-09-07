package ru.trop.lesson_5;

public class PersonMain {public static void main(String[] args){

    ServicePerson sitizen = new ServicePerson();
    sitizen.addPerson("Иван Иванов", "Москва", Fine.Административный);
    sitizen.addPerson("Петр Петров", "Санкт-Петербург", Fine.ГИБДД);
    sitizen.addPerson("Сидор Сидоров", "Казань", Fine.Налог);
    sitizen.addPerson("Анна Аннина", "Москва", Fine.Налог);


    sitizen.addFineToPerson(1, "Превышение скорости");
    sitizen.addFineToPerson(1, "Езда без ремня");
    sitizen.addFineToPerson(2, "Неуплата налога");

    sitizen.printAllData();

    sitizen.findPersonByCode(2);

    sitizen.findPersonsByFineType(Fine.Налог);

    sitizen.findPersonsByCity("Москва");

    sitizen.removeFineFromPerson(1, "Езда без ремня");
    sitizen.findPersonByCode(1);

    sitizen.updatePersonInfo(3, "Сидор Петров", "Новосибирск", Fine.ГИБДД);
    sitizen.findPersonByCode(3);

}
}
