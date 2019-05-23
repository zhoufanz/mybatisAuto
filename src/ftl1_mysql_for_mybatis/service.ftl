

public interface ${entity}Service{

    int insertSelective(${entity} ${lowerentity});

    ${entity} selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(${entity} ${lowerentity});

}
