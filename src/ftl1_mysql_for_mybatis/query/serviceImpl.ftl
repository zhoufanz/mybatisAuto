
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("${lowerentity}Service")
public class ${entity}ServiceImpl implements ${entity}Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(${entity}ServiceImpl.class);

    @Autowired
    private ${entity}Mapper ${lowerentity}Mapper;

    @Override
    public ${entity} selectByPrimaryKey(Integer id) {
        return this.${lowerentity}Mapper.selectByPrimaryKey(id);
    }

}