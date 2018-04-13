

public interface ${entity}Service{

    int insertSelective(${entity} ${lowerentity});

    ${entity} selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(${entity} ${lowerentity});

}
