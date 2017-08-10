package guru.multithread.volatileexp;
/**
 * 
 * @author Srisarguru
 *
 */
public class VolatileMethod {
 /*
  * Now that I have your attention. There is no need for volatile methods
  * Only fields can be made volatile. 
  * If methods can be made volatile then it means all threads see a consistent byte code for the method.
  * But this happens anyway because threads don't see different versions of a class they see the same compiled code 
  * so no need for volatile methods.
  */
}
