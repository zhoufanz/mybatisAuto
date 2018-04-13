import com.yung.opmanage.controller.base.BaseWebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/coupon")
public class ${entity}Controller extends BaseWebController{

	private static final Logger LOGGER = LoggerFactory.getLogger(${entity}Controller.class);

	@Autowired
	private ${entity}Service ${lowerentity}Service;
	
}