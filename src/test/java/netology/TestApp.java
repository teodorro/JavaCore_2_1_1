package netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class TestApp {

    @Test
    public void test_GetNotEmptyListOfEmployeesFromXmlFile(){
        String fileName = "data.xml";

        List<Employee> employees = App.parseXml(fileName);

        Assertions.assertNotNull(employees);
        Assertions.assertTrue(employees.size() > 0);
    }

    @Test
    public void test_ConvertEmployeesToJsonNotEmpty(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "a", "b", "c", 2),
                new Employee(2, "d", "e", "f", 3));

        String json = App.employeesToJson(employees);

        Assertions.assertNotNull(json);
        Assertions.assertFalse(json.isEmpty());
    }

    @Test
    public void test_ConvertEmployeesToJsonTwoElements(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "a", "b", "c", 2),
                new Employee(2, "d", "e", "f", 3));

        String json = App.employeesToJson(employees);

        Assertions.assertEquals(json.charAt(0), '[');
        Assertions.assertEquals(json.charAt(json.length() - 1), ']');
        Assertions.assertEquals(json.chars().filter(x -> x == '{').count(), 2);
        Assertions.assertEquals(json.chars().filter(x -> x == '}').count(), 2);
    }

    @Test
    public void test_SaveJson(){
        String filename = "asd";
        String filenameJson = "data.json";
        App.saveJson(filename);
        File asd = new File(filenameJson);

        Assertions.assertTrue(asd.exists());

        (new File(filenameJson)).delete();
    }

    @Test
    public void test_MapIntString(){
        int val = 123;

        Integer mapVal = App.mapValueString(String.valueOf(val), Integer.class);

        Assertions.assertEquals(val, mapVal);
    }

    @Test
    public void test_MapLongString(){
        long val = 123;

        Long mapVal = App.mapValueString(String.valueOf(val), Long.class);

        Assertions.assertEquals(val, mapVal);
    }

    @Test
    public void test_MapStringString(){
        String val = "asd";

        String mapVal = App.mapValueString(val, String.class);

        Assertions.assertEquals(val, mapVal);
    }
}
