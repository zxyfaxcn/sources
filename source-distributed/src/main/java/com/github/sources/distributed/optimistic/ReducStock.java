package com.github.sources.distributed.optimistic;

/**
 * 减库存操作
 * 接口层做防重操作，减库存之前申请一个业务流水号token（全局唯一）并缓存在redis中，请求接口时删除redis中的token（尽量使用删除，查询+删除不是原子操作，存在并发问题）
 * 删除成功表示第一次请求，放行执行，否则根据具体情况返回；在DB层使用乐观锁CAS保证数据一致性，
 * 扣减是一个非幂等操作，设置是一个幂等操作，所以将扣减变为设置操作，设置操作存在并发问题，所以使用CAS保证数据一致性，接口至少要成功执行一次，可以使用一定数量的自旋操作
 * 接口层还可以缓存操作结果，如果后续进来的请求发现前面的请求异常，可以根据情况放行
 */
public class ReducStock {
}
