
import org.springframework.stereotype.Service;

@Service("${lowerentity}Service")
public class ${entity}Service extends BaseServiceImpl<${entity}Entity> implements I${entity}Service {

    @Autowired
    private I${entity}Dao ${lowerentity}Dao;

    @Override
    IBaseDao<${entity}Entity, String> getBaseDao() {
        return this.${lowerentity}Dao;
    }
}
