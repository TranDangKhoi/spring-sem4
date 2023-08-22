import 'dart:convert';
import 'package:http/http.dart' as http;

void main() async {
  final apiUrl = 'http://localhost:8080/employees';

  final employees = await fetchEmployees(apiUrl);
  print('All Employees:');
  print(employees);

  final newEmployee = {
    'fullname': 'John Doe',
    'birthday': 123,
    'address': '123 Main St',
  };

  final createdEmployee = await createEmployee(apiUrl, newEmployee);
  print('Created Employee:');
  print(createdEmployee);
}

Future<List<Map<String, dynamic>>> fetchEmployees(String apiUrl) async {
  final response = await http.get(Uri.parse(apiUrl));
  if (response.statusCode == 200) {
    final List<dynamic> data = json.decode(response.body);
    return List<Map<String, dynamic>>.from(data);
  } else {
    throw Exception('Failed to fetch employees');
  }
}

Future<Map<String, dynamic>> createEmployee(
    String apiUrl, Map<String, dynamic> employee) async {
  final response = await http.post(
    Uri.parse(apiUrl),
    headers: {'Content-Type': 'application/json'},
    body: json.encode(employee),
  );

  if (response.statusCode == 200) {
    return json.decode(response.body);
  } else {
    throw Exception('Failed to create employee');
  }
}
