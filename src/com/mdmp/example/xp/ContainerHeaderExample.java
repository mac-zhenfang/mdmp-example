SQLite format 3   @                                                                     -�� � ��                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  �z!11�t a b l e I t e m T a b l e I t e m T a b l e C R E A T E   T A B L E   I t e m T a b l e   ( k e y   T E X T   U N I Q U E   O N   C O N F L I C T   R E P L A C E ,   v a l u e   B L O B   N O T   N U L L   O N   C O N F L I C T   F A I L ) [!}1 i n d e x s q l i t e _ a u t o i n d e x _ I t e m T a b l e _ 1 I t e m T a b l e                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ce(R.drawable.umeng_xp_large_gallery_failed);
							view.findViewById(R.id.umeng_xp_large_gallery_item_progressbar).setVisibility(View.GONE);
							view.findViewById(R.id.umeng_xp_large_gallery_item_imv).setVisibility(View.VISIBLE);
						}

						@Override
						public void onStart(BindMode mode, ViewGroup view) {
							view.findViewById(R.id.umeng_xp_large_gallery_item_progressbar).setVisibility(View.VISIBLE);
							view.findViewById(R.id.umeng_xp_large_gallery_item_imv).setVisibility(View.GONE);
						}

					}));
					viewMgr.addView(headerRoot, ExchangeConstants.type_large_image);
					listView.addHeaderView(headerRoot);
				}
			};
			
			ExchangeViewManager exchangeViewManager = new ExchangeViewManager(mContext,containerService);
			exchangeViewManager.addView(fatherLayout, listView);

			return root;
		}
		
	}

}
