INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('sayuri', '斷魔', '闇', 1529, 450, ARRAY['闇','血','氣'], ARRAY['出血', '沉默'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('hitomi', '噬人', '波', 1453, 399, ARRAY['波','光'], ARRAY['擊退'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('chiaki', 'Lord of Anal Beads', '淫', 142, 1840, ARRAY['淫','氣'], ARRAY['無力','噴汁','噴屎','腿軟','噴尿'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('samui', '冰の女王', '冰', 103, 543, ARRAY['冰'], ARRAY['冷凍'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('yuko', 'Goddess Eye', '知',298, 2259, ARRAY['知'], ARRAY['穿刺'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('etsuko', 'Suppressor', '風',1881, 105, ARRAY['風'], ARRAY['爆擊'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('miyako', 'Genade All Rounder', '無',495, 0, ARRAY['無'], ARRAY['炸裂'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

INSERT INTO weapon(name, weapon, attributes, base_damage, bonus_damage, bonus_attributes, state_attributes)
VALUES ('kalidasa', 'The Buddha', '淫',50, 2122, ARRAY['淫','佛'], ARRAY['腿軟','噴汁','噴尿','暈眩','四隻麻痺','屁股抽筋','噴乳汁'])
ON CONFLICT (name, weapon) DO UPDATE SET
    attributes = EXCLUDED.attributes,
    base_damage = EXCLUDED.base_damage,
    bonus_damage = EXCLUDED.bonus_damage,
    bonus_attributes = EXCLUDED.bonus_attributes,
    state_attributes = EXCLUDED.state_attributes;

