package mcm.edu.ph.rabo_wagecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView txtName, txtType, txtHours, txtWage, txtOvertime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txtName = findViewById(R.id.txtEmployeeName);
        txtType = findViewById(R.id.txtEmployeeType);
        txtHours = findViewById(R.id.txtHours);
        txtWage = findViewById(R.id.txtTotalWage);
        txtOvertime = findViewById(R.id.txtTotalOvertime);


        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtName.setText("Employee Name: " + EmployeeName);
        txtType.setText("Employee Type: " + String.valueOf(EmployeeType));
        txtHours.setText("Hours Rendered: " + String.valueOf(EmployeeHours));


        calcWage(EmployeeType, EmployeeHours, txtWage, txtOvertime);

    }

    public void calcWage(String employeeType, Double employeeHours, TextView txtWage, TextView txtOvertime) {
        double totalWage = 0;
        double totalOvertime = 0;

        if (employeeType.equals("Regular Employee")) {

            if (employeeHours <= 8) {
                totalWage = employeeHours * 100;
                totalOvertime = 0;

                txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
                txtOvertime.setText("Overtime: " + String.valueOf(totalOvertime));
            } else {
                totalWage = 8 * 100;
                totalOvertime = (employeeHours - 8) * 115;
                totalWage = totalOvertime + totalWage;

                txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
                txtOvertime.setText("Overtime: ₱" + String.valueOf(totalOvertime));
                {
                }
}
        } else if (employeeType.equals("Part-Time Worker")) {

            if (employeeHours <= 8) {
                totalWage = employeeHours * 75;
                totalOvertime = 0;

                txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
                txtOvertime.setText("Overtime: " + String.valueOf(totalOvertime));

            }else {
                totalWage = 8 * 75;
                totalOvertime = (employeeHours - 8) * 90;
                totalWage = totalOvertime + totalWage;

                txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
                txtOvertime.setText("Overtime: ₱" + String.valueOf(totalOvertime));
                {
                }
}
            }else{

                if (employeeHours <= 8) {
                    totalWage = employeeHours * 90;
                    totalOvertime = 0;

                    txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
                    txtOvertime.setText("Overtime: " + String.valueOf(totalOvertime));
                } else {
                    totalWage = 8 * 90;
                    totalOvertime = (employeeHours - 8) * 100;
                    totalWage = totalOvertime + totalWage;

                    txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
                    txtOvertime.setText("Overtime: ₱" + String.valueOf(totalOvertime));
                }
            }
        }
    }




