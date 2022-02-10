package com.tutorial.core.flower.repository.impl;

/*
@Repository
public class JDBCFlowerRepository implements FlowerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCFlowerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(Flower flower) {
         jdbcTemplate.update("INSERT INTO flower(name, price, flower_language) VALUES (?, ?, ?)"
            ,flower.getName() , flower.getPrice(), flower.getFlowerLanguage());

         return getByName(flower.getName()).getId();
    }

    @Override
    public List<Flower> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM flower ORDER BY id",
                (rs, rowNum) -> new Flower(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("flower_language")));
    }

    @Override
    public Flower getById(Integer id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM flower WHERE id = ?",
                new Object[]{id}, (rs, rowNum) ->
                        new Flower(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("price"),
                                rs.getString("flower_language")));
    }

    @Override
    public Flower getByName(String name) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM flower WHERE name = ?",
                new Object[]{name}, (rs, rowNum) ->
                        new Flower(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("price"),
                                rs.getString("flower_language")));
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM flower where id = ?", id);
    }
}
*/
