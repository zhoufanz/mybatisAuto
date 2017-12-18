
import org.springframework.stereotype.Service;

@Service("${lowerentity}Service")
public class ${entity}Service extends BaseServiceImpl<${entity}Entity> implements I${entity}Service {

    @Autowired
    private I${entity}Dao ${lowerentity}Dao;

    @Override
    void setBaseDao() {
        super.baseDao = this.${lowerentity}Dao;
    }
}
