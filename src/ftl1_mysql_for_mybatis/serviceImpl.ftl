
import org.springframework.stereotype.Service;

@Service("${lowerentity}Service")
public class ${entity}ServiceImpl implements ${entity}Service {

    @Autowired
    private ${entity}Mapper ${lowerentity}Mapper;
}
