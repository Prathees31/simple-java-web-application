package student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import student.StudentService;
import student.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

	private StudentService dao;

	public StudentServlet() {
		dao = new StudentService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		List<Student> studentList = new ArrayList<Student>();
		          Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");

		if (action != null) {
			try {
				if (action.equals("list")) {
					// Fetch Data from Student Table
					studentList = dao.getAllStudents();

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Records", studentList);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);

					response.getWriter().print(jsonArray);
				} else if (action.equals("create") || action.equals("update")) {
					Student student = new Student();
					if (request.getParameter("rollno") != null) {
						int rollno = Integer.parseInt(request.getParameter("rollno"));
						student.setRollNo(rollno);
					}

					if (request.getParameter("name") != null) {
						String name = request.getParameter("name");
						student.setName(name);
					}

					if (request.getParameter("department") != null) {
						String department = request.getParameter("department");
						student.setDepartment(department);
					}

					if (request.getParameter("section") != null) {
						String section = request.getParameter("section");
						student.setSection(section);
					}
                                                                                                     if (request.getParameter("fname") != null) {
						String fname = request.getParameter("fname");
						student.setFname(fname);
					}
                                                                                                     if (request.getParameter("address") != null) {
						String address = request.getParameter("address");
						student.setAddress(address);
					}
                                                                                                     if (request.getParameter("mobile") != null) {
						String mobile = request.getParameter("mobile");
						student.setMobile(mobile);
					}

					if (action.equals("create")) {
						// Create new record
						dao.addStudent(student);
					} else if (action.equals("update")) {
						// Update existing record
						dao.updateStudent(student);
					}

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Record", student);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);
					response.getWriter().print(jsonArray);
				} else if (action.equals("delete")) {
					// Delete record
					if (request.getParameter("rollno") != null) {
						int rollno = Integer.parseInt(request.getParameter("rollno"));
						dao.deleteStudent(rollno);

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}
				}
			} catch (Exception ex) {
				JSONROOT.put("Result", "ERROR");
				JSONROOT.put("Message", ex.getMessage());
				String error = gson.toJson(JSONROOT);
				response.getWriter().print(error);
			}
		}
	}
}