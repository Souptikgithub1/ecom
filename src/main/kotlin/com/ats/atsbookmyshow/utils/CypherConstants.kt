package com.ats.atsbookmyshow.utils

object CypherConstants {
    const val CREATE_SINGLE_CAT_NODE =
        "CREATE (c:Category {categoryId:{categoryId}, categoryName:{categoryName}, categoryDesc:{categoryDesc},  activeInd:{activeInd}}) RETURN 'DONE' AS status"
    const val CREATE_MULTIPLE_CAT_NODES =
        "UNWIND {props} AS map CREATE (n:Category) SET n = map RETURN 'DONE' AS status"
    const val CREATE_NODE_RELATIONSHIP =
        "MATCH (a:Category),(b:Category) WHERE a.categoryId = {parentId} AND b.categoryId IN {childIds} CREATE (a)<-[r:BELONGS_TO]-(b) RETURN type(r) AS relation"
    const val CREATE_MULTIPLE_RELATIONSHIPS =
        "UNWIND {props} AS map MATCH (a:Category),(b:Category) WHERE a.categoryId = map.parentId AND b.categoryId IN map.childIds CREATE (a)<-[:BELONGS_TO]-(b) RETURN 'DONE' AS status"
    const val NODE_BY_CAT_ID = "MATCH (C:Category{categoryId:\$categoryId}) RETURN C"
    const val MATCH_PARENT_NODES = "MATCH p = ((c:Category)-[:BELONGS_TO*0..]->(other))"
    const val STATUS_DONE = "DONE"
    const val WHERE = " WHERE "
    const val AND = " AND "
    const val CATEGORY_ID_CONDITION = "c.categoryId = {categoryId} "
    const val CATEGORY_NAME_CONDITION = "c.categoryName = {categoryName} "
    const val COLLECT_ALL_PARENT_CAT_NODES = "WITH reduce(output = [], n IN nodes(p) | output + n ) as nodes " +
            "UNWIND nodes as category " +
            "WITH category ORDER BY category.categoryId " +
            "RETURN distinct category.categoryId as catId "
    const val MATCH_ALL_NEXT_LEVEL_CHILD_CATEGORIES = " MATCH ((c:Category)<-[:BELONGS_TO]-(n)) "
    const val COLLECT_ALL_NEXT_LEVEL_CHILD_CATEGORIES = " return distinct " +
            " n.categoryId AS categoryId, " +
            " n.categoryName AS categoryName, " +
            " n.categoryDesc AS categoryDesc, " +
            " n.country AS country, " +
            " n.subDomain AS subDomain, " +
            " n.activeInd AS activeInd " +
            " ORDER BY n.categoryId " +
            " SKIP {offset} " +
            " LIMIT {pageSize} "
    const val COLLECT_COUNT_OF_ALL_NEXT_LEVEL_CHILD_CATEGORIES = " return count(n) AS count "
    const val DELETE_NODES_AND_ALL_RELATIONSHIP =
        "MATCH (n) WHERE n.%s %s {fieldValue} DETACH DELETE n return count(n) as count"
    const val COUNT_OF_CATEGORY_NODES = "MATCH(n:Category) WHERE n.categoryId %s %s RETURN count(n) AS count"
    const val FIELD_VALUE = "fieldValue"
    const val CATEGORY_ID = "categoryId"
    const val CATEGORY_NAME = "categoryName"
    const val CATEGORY_DESC = "categoryDesc"
    const val SUB_DOMAIN = "subDomain"
    const val COUNTRY = "country"
    const val ACTIVE_INDC = "activeInd"
    const val STATUS = "status"
    const val CREATE_CATEGORY_PARENT_CHILD_RELATION =
        "MATCH (a:Category),(b:Category) WHERE a.categoryId = {parentId} AND b.categoryId = {childId} CREATE (a)<-[r:BELONGS_TO]-(b) RETURN type(r) AS relation"
    const val FETCH_PARENT_CAT_BY_CHILD_CAT_ID =
        "MATCH (parent:Category)<-[:BELONGS_TO]-(child:Category) WHERE child.categoryId={categoryId} RETURN parent"
    const val DELETE_RELATION_FROM_PARENT =
        "MATCH (parent:Category {categoryId: \$parentCatId})<-[r:BELONGS_TO]-(b:Category {categoryId: \$childCatId}) DELETE r RETURN b"
}