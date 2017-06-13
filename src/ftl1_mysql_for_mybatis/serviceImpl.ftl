
import org.springframework.stereotype.Service;

@Service("${lowerentity}Service")
public class ${entity}Service implements I${entity}Service {

    @Autowired
    private I${entity}Dao ${lowerentity}Dao;
}
