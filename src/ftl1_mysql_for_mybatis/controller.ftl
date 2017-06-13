import com.ycgwl.framework.springmvc.controller.AbstractController;

@Controller
@RequestMapping("/mm")
public class ${entity}Controller extends AbstractController{
	
	@Autowired
	private I${entity}Service ${lowerentity}Service;
	
}