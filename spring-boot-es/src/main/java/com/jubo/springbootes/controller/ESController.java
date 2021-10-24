package com.jubo.springbootes.controller;

import com.jubo.springbootes.dto.ResultDto;
import com.jubo.springbootes.util.ESClient;
import lombok.SneakyThrows;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.elasticsearch.index.query.QueryBuilders.matchPhraseQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * @author JUBO
 */
@RestController
@RequestMapping("/car")
public class ESController {
    RestHighLevelClient client = ESClient.getInstance().getHighLevelClient();

    @RequestMapping("/init")
    @SneakyThrows
    public String indexInit() {

        return "/car/init";
    }

    @RequestMapping("/carInfo")
    @SneakyThrows
    public ResultDto carInfo(@RequestParam(value = "keyword", required = true)
                             String keyWord,
                             @RequestParam(value = "from", required = true)
                             Integer from,
                             @RequestParam(value = "size", required = true)
                             Integer size) {
        ResultDto res = new ResultDto();
        res.setData("");
        return res;
    }

    @RequestMapping("/scroll")
    @SneakyThrows
    public ResultDto scroll(String scrollId) {

        ResultDto res = new ResultDto();
        return res;
    }

    @RequestMapping("/fuzzy")
    @SneakyThrows
    public SearchHit[] fuzzy(String name) {
        SearchRequest searchRequest = new SearchRequest("msb_auto");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.fuzzyQuery("brand_name.keyword", name).fuzziness(Fuzziness.AUTO));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        return response.getHits().getHits();
    }

    /**
     *
     * @return
     */
    @RequestMapping("/bulk")
    @SneakyThrows
    public ResultDto bulk() {
        SearchRequest searchRequest = new SearchRequest("msb_auto");
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest("msb_auto", "13"));
        request.add(new UpdateRequest("msg_auto", "22")
            .doc(XContentType.JSON, "series_name", "天籁之音"));
        request.add(new IndexRequest("msb_auto").id("4")
            .source(XContentType.JSON, "brand_name", "天津一汽"));
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);

        return null;
    }

    @RequestMapping("/templateSearch")
    @SneakyThrows
    public ResultDto templateSearch() {

        return null;
    }

    @RequestMapping("/multiSearch")
    @SneakyThrows
    public ResultDto multiSearch() {
        MultiSearchRequest request = new MultiSearchRequest();

        SearchRequest firstSearchRequest = new SearchRequest("msb_auto");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("series_name", "朗动"));
        firstSearchRequest.source(searchSourceBuilder);
        request.add(firstSearchRequest);

        SearchRequest secondSearchRequest = new SearchRequest("msb_auto");
        searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("series_name", "揽胜运动"));
        secondSearchRequest.source(searchSourceBuilder);
        request.add(secondSearchRequest);

        MultiSearchResponse response = client.msearch(request, RequestOptions.DEFAULT);

        return null;
    }

    @RequestMapping("/boolSearch")
    @SneakyThrows
    public ResultDto boolSearch() {
        MultiSearchRequest request = new MultiSearchRequest();

        SearchRequest searchRequest = new SearchRequest("msb_auto");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(
            QueryBuilders.boolQuery()
            .must(matchPhraseQuery("sale_name", "2018款"))
            .filter(matchQuery("master_brand_name", "大众")
                .analyzer("ik_max_word"))
            .mustNot(matchQuery("series_name", "速腾"))
        );
        searchRequest.source(searchSourceBuilder);
        request.add(searchRequest);
        MultiSearchResponse response = client.msearch(request, RequestOptions.DEFAULT);

        return null;
    }
}
