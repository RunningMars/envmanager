package com.bikego.env.management.controller.testCase.part3;

import org.junit.Test;

public class
字符串String {

    @Test
    public void test()
    {
        /**
         * 跨行长字符串的写法之一
         * 另一种为 str.append("n.location_type_name")的思路;
         */
        String str = "SELECT"
                + "sum(n.total_amount) as total_amount,"
                + "n.`location_type_id`,"
                + "n.clinic_id,"
                + "n.clinic_name,"
                + "n.clinic_type,"
                + "n.customer_type,"
                + "n.customer_id,"
                + "n.customer_name,"
                + "n.location_type_name"
                + "FROM"
                + "     ("
                + "                SELECT"
                + "                `order`.id,"
                + "                  `order`.total_amount,"
                + "                  `order`.location_type_id,"
                + "                  `location_type`.name as location_type_name,"
                + "IFNULL(dash_clinic.id,'others') as clinic_id,"
                + "IFNULL(dash_clinic.name,'others') as clinic_name,"
                + "IFNULL(dash_clinic.type,'others') as clinic_type,"
                + "IFNULL(dash_customer.id,'others') as customer_id,"
                + "IFNULL(dash_customer.name,'others') as customer_name,"
                + "IFNULL(dash_customer.type,'others') as customer_type"
                + "FROM"
                + "                  `order`"
                + "LEFT JOIN"
                + "                  `dash_hv_clinic_relation` ON `dash_hv_clinic_relation`.hv_clinic_id = `order`.hv_clinic_id AND dash_hv_clinic_relation.deleted_at IS NULL"
                + "LEFT JOIN"
                + "                  `dash_clinic` ON dash_clinic.id = dash_hv_clinic_relation.dash_clinic_id OR dash_clinic.id = `order`.dash_clinic_id"
                + "LEFT JOIN"
                + "                  `hv_clinic` ON hv_clinic.hv_clinic_id = `order`.hv_clinic_id"
                + "LEFT JOIN"
                + "customer_corporate_relation ON customer_corporate_relation.hv_corporate_id = `order`.hv_corporate_id AND customer_corporate_relation.deleted_at IS NULL"
                + "LEFT JOIN"
                + "dash_customer ON dash_customer.id = customer_corporate_relation.dash_customer_id OR dash_customer.id = `order`.dash_customer_id"
                + "LEFT JOIN"
                + "location_type ON location_type.id = `order`.location_type_id"
                + "    WHERE"
                + "GROUP BY `order`.id"
                + "          ) as n";

        System.out.println(str);
    }
}
