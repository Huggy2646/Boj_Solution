-- 코드를 작성해주세요
select first.id, sec.fish_name, first.length
from
    (
    select a.fish_type, a.length,a.id
    from
        fish_info as a
        join(
            select fish_type,max(length)as length
            from fish_info
            group by fish_type
        ) as b
        on a.fish_type=b.fish_type and b.length = a.length
    ) as first
    left join fish_name_info as sec on first.fish_type=sec.fish_type

order by first.id
