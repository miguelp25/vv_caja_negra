import com.practica.cajanegra.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({IsSubListTest.class, RemoveLastMethods.class, ReverseTest.class, SizeTest.class, ToStringTest.class})
public class TestAll {}