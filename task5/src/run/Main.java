package run;

import compare.PriceComparator;
import entity.Device;
import read.InfoReader;
import valid.ValidatorXML;
import java.io.IOException;
import java.util.List;

/*
    5. Компьютеры.
Компьютерные комплектующие имеют следующие характеристики:
— Name — название комплектующего;
— Origin — страна производства;
— Price — цена (0‒n рублей);
— Type (должно быть несколько) — периферийное либо нет, энергопотребление
(ватт), наличие кулера (есть либо нет), группа комплектующих
(устройства ввода-вывода, мультимедийные), порты (COM, USB, LPT);
— Critical — критично ли наличие комплектующего для работы компьютера.
Корневой элемент назвать Device.
 */

public class Main {
    public static void main(String[] args) {
        ValidatorXML validator = new ValidatorXML("data//devices.xml", "data//devices.xsd");
        try {
            if (validator.validate()) {
                InfoReader reader = new InfoReader();
                List<Device> devices = reader.read("data//devices.xml");
                for (Device device : devices) {
                    System.out.println(device + "\n");
                }
                devices.sort(new PriceComparator());
                for (Device device : devices) {
                    System.out.println(device + "\n");
                }
            } else {
                System.out.println(validator.getError());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
