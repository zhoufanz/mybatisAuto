import com.ycgwl.framework.springmvc.controller.AbstractController;

@Controller
@RequestMapping("/mm")
public class ${entity}Controller extends AbstractController{
	
	@Resource
	private I${entity}Service ${lowerentity}Service;
	
}